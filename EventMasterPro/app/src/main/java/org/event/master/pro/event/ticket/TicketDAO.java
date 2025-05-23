/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.event.master.pro.event.ticket;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.event.master.pro.enums.TicketStatus;
import org.event.master.pro.util.Database;
import org.event.master.pro.util.sql.Insert;
import org.event.master.pro.util.sql.Select;
import org.event.master.pro.util.sql.Update;

/**
 *
 * @author Luisa
 */
public class TicketDAO {
    public void saveTicket(int id, List<Ticket> ticket) throws SQLException {
        String sql = Insert.INSERT_TICKET.getQuery();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            for (Ticket t : ticket) {
                stmt.setDouble(1, t.getPrice());
                stmt.setInt(2,t.getSeatNumber());
                stmt.setString(3, t.getZone());
                stmt.setString(4, t.getDescription());
                stmt.setInt(5, id);
                stmt.setString(6, t.getStatus().name());
                stmt.executeUpdate();
            }
        }
    }
    
    public List<Ticket> ticketByEvent(int eventId) throws SQLException{
        List<Ticket> tickets = new ArrayList<>();
        String sql = Select.SELECT_TICKET_BY_EVENT.getQuery();
         try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setInt(1, eventId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Ticket t = new Ticket();
                t.setIdTicket(rs.getInt("id_ticket"));
                t.setPrice(rs.getDouble("price"));
                t.setSeatNumber(rs.getInt("seat_number"));
                t.setZone(rs.getString("zone"));
                t.setDescription(rs.getString("description"));
                t.setStatus(TicketStatus.valueOf(rs.getString("status")));
                tickets.add(t);
            }
        }
        
        return tickets;
    }
    
    public void changeStatus(int ticketId, TicketStatus status) throws SQLException {
        String sql = Update.CHANGE_STATIS_TICKET.getQuery();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setString(1, status.name());
            stmt.setInt(2, ticketId);
            stmt.executeUpdate();
        }
    }
    
    public void sellTicket(int ticketId, int customerId) throws SQLException {
        String updateSql = Update.SELL_TICKET.getQuery();
        try (PreparedStatement stmt = Database.connection().prepareStatement(updateSql)) {
            stmt.setString(1, TicketStatus.SOLD.name());
            stmt.setInt(2, ticketId);
            stmt.executeUpdate();
        }
        String insertSql = Insert.ASSIGN_TICKET_TO_CUSTOMER.getQuery();
        try (PreparedStatement stmt = Database.connection().prepareStatement(insertSql)) {
            stmt.setInt(1, ticketId);
            stmt.setInt(2, customerId);
            stmt.executeUpdate();
        }
    }
}
