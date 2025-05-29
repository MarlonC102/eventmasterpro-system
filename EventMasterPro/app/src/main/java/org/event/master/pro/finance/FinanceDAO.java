/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.event.master.pro.finance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.event.master.pro.enums.EventStatus;
import org.event.master.pro.event.Event.EventDAO;
import org.event.master.pro.util.Database;
import org.event.master.pro.util.sql.Insert;
import org.event.master.pro.util.sql.Select;
import org.event.master.pro.util.sql.Update;

/**
 *
 * @author Luisa
 */
public class FinanceDAO {

    public void saveFinance(int eventId, double budget) {
        EventDAO edao = new EventDAO();
        String sql = Insert.SAVE_FINANCE.getQuery();
        try (Connection conn = Database.connection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, eventId);
            stmt.setDouble(2, budget);
            stmt.setInt(3, 4);
            stmt.executeUpdate();
            int financeId = -1;
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    financeId = rs.getInt(1);
                } else {
                    System.err.println("No se generó el ID de finance.");
                    return;
                }
            }
            edao.updateEventStatus(eventId, EventStatus.Published);
            String sqlArtist = Select.SELECT_PRINCIPAL_ARTIST_PRICE.getQuery();
            try (PreparedStatement stmtArtist = conn.prepareStatement(sqlArtist)) {
                stmtArtist.setInt(1, eventId);
                ResultSet rsArtist = stmtArtist.executeQuery();
                if (rsArtist.next()) {
                    double artistPrice = rsArtist.getDouble("price_artist");
                    String artistName = rsArtist.getString("name");
                    saveExpense(financeId, "Principal Artist: " + artistName, artistPrice, "Artist Fee");
                }
            }

            String sqlInvited = Select.SELECT_INVITED_ARTIST_PRICE.getQuery();
            try (PreparedStatement stmtInvited = conn.prepareStatement(sqlInvited)) {
                stmtInvited.setInt(1, eventId);
                ResultSet rsInvited = stmtInvited.executeQuery();
                while (rsInvited.next()) {
                    double artistPrice = rsInvited.getDouble("price_artist") * 0.5;
                    String artistName = rsInvited.getString("name");
                    saveExpense(financeId, "Invited Artist: " + artistName, artistPrice, "Artist Fee");
                }
            }

            String sqlLocation = Select.SELECT_LOCATION_PRICE.getQuery();
            try (PreparedStatement stmtLocation = conn.prepareStatement(sqlLocation)) {
                stmtLocation.setInt(1, eventId);
                ResultSet rsLocation = stmtLocation.executeQuery();
                if (rsLocation.next()) {
                    double locationPrice = rsLocation.getDouble("price_location");
                    String locationName = rsLocation.getString("name");
                    saveExpense(financeId, "Location: " + locationName, locationPrice, "Location Rent");
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int countFinanceAssigned(int eventId) {
        int count = 0;
        String checkFinance = Select.SELECT_FINANCE_ASSIGNED.getQuery();
        try (Connection conn = Database.connection(); PreparedStatement stmt = conn.prepareStatement(checkFinance)) {
            stmt.setInt(1, eventId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return count;
    }

    public Finance getFullFinanceByEventId(int eventId) {
        Finance finance = null;
        String sqlFinance = Select.SELECT_FULL_FINANCE.getQuery();
        try (Connection conn = Database.connection(); PreparedStatement stmt = conn.prepareStatement(sqlFinance)) {
            stmt.setInt(1, eventId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int financeId = rs.getInt("id_finance");
                finance = new Finance();
                finance.setId(financeId);
                finance.setEventId(eventId);
                finance.setListRevenues(getRevenueByFinanceId(financeId));
                finance.setListExpense(getExpenseByFinance(financeId));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FinanceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return finance;
    }

    public void updateFinance(int eventId, double newBudget) {
        String sql = Update.UPDATE_FINANCE.getQuery();
        String getFinance = Select.SELECT_FINANCE_BY_ID_EVENT.getQuery();
        String updateBalance = Update.UPDATE_FINANCE_BALANCE.getQuery();

        try (Connection conn = Database.connection()) {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setDouble(1, newBudget);
                stmt.setInt(2, eventId);
                stmt.executeUpdate();
            }
            int financeId = -1;
            double income = 0, expenses = 0;
            try (PreparedStatement stmt = conn.prepareStatement(getFinance)) {
                stmt.setInt(1, eventId);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    financeId = rs.getInt("id_finance");
                    income = rs.getDouble("income_total");
                    expenses = rs.getDouble("expenses_total");
                }
            }

            if (financeId != -1) {
                double balance = newBudget + income - expenses;
                try (PreparedStatement stmt = conn.prepareStatement(updateBalance)) {
                    stmt.setDouble(1, balance);
                    stmt.setInt(2, financeId);
                    stmt.executeUpdate();
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void saveExpense(int financeId, String description, double amount, String category) throws SQLException {
        String insertExpenseSQL = Insert.ADD_EXPENSE.getQuery();
        String getFinanceSQL = Select.SELECT_FINANCE_BY_ID.getQuery();
        String updateFinanceSQL = Update.UPDATE_FINANCE_TOTALS_EXPENSE.getQuery(); // actualiza expenses y balance

        try (Connection conn = Database.connection()) {
            try (PreparedStatement stmt = conn.prepareStatement(insertExpenseSQL)) {
                stmt.setString(1, description);
                stmt.setDouble(2, amount);
                stmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                stmt.setString(4, category);
                stmt.setInt(5, financeId);
                stmt.executeUpdate();
            }

            // 2. Obtener datos actuales
            double budget = 0, income = 0, expenses = 0;
            try (PreparedStatement stmt = conn.prepareStatement(getFinanceSQL)) {
                stmt.setInt(1, financeId);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    budget = rs.getDouble("budget_total");
                    income = rs.getDouble("income_total");
                    expenses = rs.getDouble("expenses_total");
                }
            }

            // 3. Actualizar expenses y balance
            expenses += amount;
            double balance = budget + income - expenses;

            try (PreparedStatement stmt = conn.prepareStatement(updateFinanceSQL)) {
                stmt.setDouble(1, expenses);
                stmt.setDouble(2, balance);
                stmt.setInt(3, financeId);
                stmt.executeUpdate();
            }

        }
    }

    public void saveRevenue(Revenue revenue) throws SQLException {
        String sql = Insert.ADD_REVENUE.getQuery();
        String getFinanceSQL = Select.SELECT_FINANCE_BY_ID.getQuery();
        String updateFinanceSQL = Update.UPDATE_FINANCE_TOTALS.getQuery(); // actualiza income, balance

        try (Connection conn = Database.connection()) {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, revenue.getDescription());
                stmt.setDouble(2, revenue.getAmount());
                stmt.setTimestamp(3, Timestamp.valueOf(revenue.getDate()));
                stmt.setString(4, revenue.getSource());
                stmt.setInt(5, revenue.getFinanceId());
                stmt.executeUpdate();
            }
            double budget = 0, income = 0, expenses = 0;
            try (PreparedStatement stmt = conn.prepareStatement(getFinanceSQL)) {
                stmt.setInt(1, revenue.getFinanceId());
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    budget = rs.getDouble("budget_total");
                    income = rs.getDouble("income_total");
                    expenses = rs.getDouble("expenses_total");
                }
            }
            income += revenue.getAmount();
            double balance = budget + income - expenses;

            try (PreparedStatement stmt = conn.prepareStatement(updateFinanceSQL)) {
                stmt.setDouble(1, income);
                stmt.setDouble(2, balance);
                stmt.setInt(3, revenue.getFinanceId());
                stmt.executeUpdate();
            }
        }
    }

    public List<Revenue> getRevenueByFinanceId(int financeId) throws SQLException {
        List<Revenue> revenues = new ArrayList<>();
        String sql = Select.SELECT_REVENUE.getQuery();
        try (Connection conn = Database.connection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
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
        try (Connection conn = Database.connection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
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

    public void updateFinanceWithRevenue(int eventId, double ticketPrice) throws SQLException {
        String sql = "UPDATE finance SET income_total = income_total + ?, balance = balance + ? WHERE event_id = ?";
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setDouble(1, ticketPrice);
            stmt.setDouble(2, ticketPrice);
            stmt.setInt(3, eventId);
            stmt.executeUpdate();
        }
    }
}
