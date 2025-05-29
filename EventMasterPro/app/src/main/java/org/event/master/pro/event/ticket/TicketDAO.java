/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.event.master.pro.event.ticket;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                stmt.setInt(2, t.getSeatNumber());
                stmt.setString(3, t.getZone());
                stmt.setString(4, t.getDescription());
                stmt.setInt(5, id);
                stmt.setString(6, t.getStatus().name());
                stmt.executeUpdate();
            }
        }
    }

    public List<Ticket> ticketByEvent(int eventId) throws SQLException {
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

    public List<Ticket> ticketsByEvent(int eventId) throws SQLException {
        List<Ticket> tickets = new ArrayList<Ticket>();
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

    public void updateTicketStatus(int ticketId, TicketStatus status) {
        String sql = Update.CHANGE_STATIS_TICKET.getQuery();
        try (PreparedStatement stmt = Database.connection().prepareCall(sql)) {
            stmt.setString(1, status.name());
            stmt.setInt(2, ticketId);
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Ticket validateTicket(int ticketId) throws SQLException {
        String sql = "SELECT * FROM ticket_detail WHERE ticket_id = ? AND status = 'SOLD'";
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setInt(1, ticketId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Ticket t = new Ticket();
                t.setIdTicket(ticketId);
                return t;
            }
            ticketUser(ticketId);
        }
        return null;
    }

    public void ticketUser(int ticketId) {
        String sql = Update.TICKET_USED.getQuery();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setString(1, "USED");
            stmt.setInt(2, ticketId);
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int countUsedTicketByEvent(int eventId) throws SQLException {
        String sql = Select.ATTENDANCE.getQuery();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setInt(1, eventId);
            stmt.setString(2, TicketStatus.USED.name());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public Ticket randomTicket(int eventId) throws SQLException {
        String sql = """
        SELECT t.* FROM ticket t
        LEFT JOIN (
            SELECT ticket_id, COUNT(*) AS sold
            FROM ticket_detail
            GROUP BY ticket_id
        ) d ON t.id_ticket = d.ticket_id
        WHERE t.event_id = ? AND (d.sold IS NULL OR d.sold < t.seat_number)
        ORDER BY RAND()
        LIMIT 1
    """;

        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setInt(1, eventId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                TicketStatus status = TicketStatus.valueOf(rs.getString("status_ticket").toUpperCase());
                return new Ticket(
                        rs.getInt("id_ticket"),
                        rs.getString("description"),
                        rs.getDouble("price_ticket"),
                        status,
                        rs.getInt("seat_number"),
                        rs.getString("zone"),
                        rs.getInt("event_id")
                );
            }
        }
        return null;
    }

    public int countTicketDetailsByTicketId(int ticketId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM ticket_detail WHERE ticket_id = ?";
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setInt(1, ticketId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }

    public void insertTicketDetail(int ticketId, int customerId) throws SQLException {
        String sql = "INSERT INTO ticket_detail (ticket_id, customer_id) VALUES (?, ?)";
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setInt(1, ticketId);
            stmt.setInt(2, customerId);
            stmt.executeUpdate();
        }
    }

    public List<Ticket> getTicketsByPersonId(int personId) throws SQLException {
        List<Ticket> tickets = new ArrayList<>();
        String sql = """
        SELECT t.id_ticket, t.status_ticket
        FROM ticket t
        JOIN ticket_detail td ON t.id_ticket = td.ticket_id
        JOIN customer c ON td.customer_id = c.id_customer
        WHERE c.person_id = ?
    """;
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setInt(1, personId);
            ResultSet rs = stmt.executeQuery();
            System.out.println(stmt);
            while (rs.next()) {
                Ticket t = new Ticket();
                t.setIdTicket(rs.getInt("id_ticket"));
                t.setStatus(TicketStatus.valueOf(rs.getString("status_ticket").toUpperCase()));
                tickets.add(t);
            }
        }
        return tickets;

    }

}
