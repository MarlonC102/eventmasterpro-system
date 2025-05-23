/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.event.master.pro.finance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.event.master.pro.util.Database;
import org.event.master.pro.util.sql.Insert;
import org.event.master.pro.util.sql.Select;
import org.event.master.pro.util.sql.Update;

/**
 *
 * @author Luisa
 */
public class FinanceDAO {
    public void saveRevenue(Revenue revenue) throws SQLException {
        String sql = Insert.ADD_REVENUE.getQuery();
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, revenue.getDescription());
            stmt.setDouble(2, revenue.getAmount());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(revenue.getDate()));
            stmt.setString(4, revenue.getSource());
            stmt.setInt(5, revenue.getFinanceId());
            stmt.executeUpdate();
        }
    }

    public void saveExpense(Expense expense) throws SQLException {
        String sql = Insert.ADD_EXPENSE.getQuery();
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, expense.getDescription());
            stmt.setDouble(2, expense.getAmount());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(expense.getDate()));
            stmt.setString(4, expense.getCategory());
            stmt.setInt(5, expense.getFinanceId());
            stmt.executeUpdate();
        }
    }
    
        public List<Revenue> getRevenueByFinanceId(int financeId) throws SQLException {
        List<Revenue> revenues = new ArrayList<>();
        String sql = Select.SELECT_REVENUE.getQuery();
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, financeId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Revenue r = new Revenue();
                r.setId(rs.getInt("id_revenue"));
                r.setDescription(rs.getString("description"));
                r.setAmount(rs.getDouble("amount"));
                r.setDate(rs.getTimestamp("date").toLocalDateTime());
                r.setSource(rs.getString("source"));
                r.setFinanceId(financeId);
                revenues.add(r);
            }
        }
        return revenues;
    }

    public List<Expense> getExpenseByFinance(int financeId) throws SQLException {
        List<Expense> expenses = new ArrayList<>();
        String sql = Select.SELECT_EXPENSE.getQuery();
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, financeId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Expense e = new Expense();
                e.setId(rs.getInt("id_expense"));
                e.setDescription(rs.getString("description"));
                e.setAmount(rs.getDouble("amount"));
                e.setDate(rs.getTimestamp("date").toLocalDateTime());
                e.setCategory(rs.getString("category"));
                e.setFinanceId(financeId);
                expenses.add(e);
            }
        }
        return expenses;
    }
    
     private void addMovementsFinance(int financeId) throws SQLException {
        double totalRevenue = 0;
        double totalExpense = 0;

        for (Revenue r : getRevenueByFinanceId(financeId)) {
            totalRevenue += r.getAmount();
        }

        for (Expense e : getExpenseByFinance(financeId)) {
            totalExpense += e.getAmount();
        }

        double balance = totalRevenue - totalExpense;

        String sql = Update.ADD_MOVEMENTS.getQuery() ;
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, totalRevenue);
            stmt.setDouble(2, totalExpense);
            stmt.setDouble(3, balance);
            stmt.setInt(4, financeId);
            stmt.executeUpdate();
        }
    }
    
}
