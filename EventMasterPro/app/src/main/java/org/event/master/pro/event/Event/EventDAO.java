/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.event.master.pro.event.Event;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.event.master.pro.enums.EventStatus;
import org.event.master.pro.enums.TicketStatus;
import org.event.master.pro.event.location.Location;
import org.event.master.pro.event.location.LocationDAO;
import org.event.master.pro.event.ticket.Ticket;
import org.event.master.pro.person.artist.Artist;
import org.event.master.pro.person.artist.ArtistDAO;
import org.event.master.pro.util.Database;
import org.event.master.pro.util.sql.Select;
import org.event.master.pro.util.sql.Update;

/**
 *
 * @author Luisa
 */
public class EventDAO implements IEvent{

    @Override
    public int countAllEventsInProgress(String query) {
        String sql = query;
        int eventInProgress = 0;
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                eventInProgress = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error SQL: " + e.getMessage());
        }
        return eventInProgress;
    }
    
    public List<Event> consultEvent(String statusEvent){
        LocationDAO l = new LocationDAO();
        String sql = Select.SELECT_EVENT.getQuery();
        List<Event> events = new ArrayList<Event>();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setString(1, statusEvent);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int eventId = rs.getInt("id_event");
                String name = rs.getString("name");
                LocalDateTime date = rs.getTimestamp("date_event").toLocalDateTime();
                String type = rs.getString("type_location");
                String description = rs.getString("description");
                Location location = new Location(rs.getString("location_name"),rs.getInt("id_location"));
                int participantsNumbers = rs.getInt("participants_number");
                String status = rs.getString("status_event");
                Event c = new Event (eventId, name, description, date, type, location, participantsNumbers);
                c.setStatusEvent(status);
                events.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL Error: " + e.getMessage());
        }return events;
    }

    @Override
    public void updateEventStatus(int eventId, EventStatus status) {
       String sql = Update.UPDATE_EVENT_STATUS.getQuery(); 
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setString(1, status.name());
            stmt.setInt(2, eventId);
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void cancelFinanceStatus(int financeId){
        String sql = Update.CANCEL_FINANCE_STATUS.getQuery();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setInt(1, financeId);
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public static List<Artist> getInvitedArtists(int eventId) throws SQLException {
    List<Artist> artists = new ArrayList<>();
    String sql = Select.SELECT_INVITED_ARTIST.getQuery();
    try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
        stmt.setInt(1, eventId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Artist a = new Artist();
            a.setIdArtist(rs.getInt("id_artist"));
            a.setGenre(rs.getString("genre_topic"));
            a.setPrice(rs.getDouble("price_artist"));
            a.setRequirements(rs.getString("requirements"));
            a.setName(rs.getString("name"));
            artists.add(a);
        }
    }

    return artists;
}
        
    public static List<Ticket> getTicketsByEventId(int eventId) throws SQLException {
    List<Ticket> tickets = new ArrayList<>();
    String sql = Select.SELECT_TICKET_BY_EVENT.getQuery();

    try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
        stmt.setInt(1, eventId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Ticket t = new Ticket();
            t.setIdTicket(rs.getInt("id_ticket"));
            t.setZone(rs.getString("zone"));
            t.setSeatNumber(rs.getInt("seat_number"));
            t.setPrice(rs.getDouble("price"));
            t.setStatus(TicketStatus.valueOf(rs.getString("status")));
            tickets.add(t);
        }
    }

    return tickets;
}

    
    
}
