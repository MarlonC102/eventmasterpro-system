/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.event.master.pro.event.Event;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.event.master.pro.enums.EventStatus;
import org.event.master.pro.enums.TicketStatus;
import org.event.master.pro.event.Event.Event;
import org.event.master.pro.event.location.Location;
import org.event.master.pro.event.location.LocationDAO;
import org.event.master.pro.event.ticket.Ticket;
import org.event.master.pro.event.ticket.TicketDAO;
import org.event.master.pro.person.artist.Artist;
import org.event.master.pro.person.artist.ArtistDAO;
import org.event.master.pro.util.Database;
import org.event.master.pro.util.sql.Insert;
import org.event.master.pro.util.sql.Select;
import org.event.master.pro.util.sql.Update;

/**
 *
 * @author Luisa
 */
public class EventDAO {

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

    public List<Event> consultEvent(String statusEvent) {
        String sql = Select.SELECT_EVENT.getQuery();
        List<Event> events = new ArrayList<Event>();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setString(1, statusEvent);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int eventId = rs.getInt("id_event");
                String name = rs.getString("name");
                LocalDateTime date = rs.getTimestamp("date_event").toLocalDateTime();
                String type = rs.getString("event_type");
                String description = rs.getString("description");
                Location location = new Location(rs.getString("location_name"), rs.getInt("id_location"));
                int participantsNumbers = rs.getInt("participants_number");
                String status = rs.getString("status_event");
                Event c = new Event(eventId, name, description, date, type, location, participantsNumbers);
                c.setStatusEvent(status);
                events.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL Error: " + e.getMessage());
        }
        return events;
    }

    public void updateEventStatus(int eventId, EventStatus status) {
        String sql = Update.UPDATE_EVENT_STATUS.getQuery();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setString(1, status.name());
            stmt.setInt(2, eventId);
            stmt.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void cancelFinanceStatus(int financeId) {
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
                t.setPrice(rs.getDouble("price_ticket"));
                t.setStatus(TicketStatus.valueOf(rs.getString("status_ticket").toUpperCase()));
                tickets.add(t);
            }
        }

        return tickets;
    }

    public void saveEvent(Event event, List<Ticket> ticket) throws SQLException {
        String checkLocation = Select.SELECT_COUNT_LOCATION_OCCUPED.getQuery();
        String sql = Insert.INSERT_EVENT.getQuery();
        TicketDAO tdao = new TicketDAO();

        try (PreparedStatement checkStmt = Database.connection().prepareStatement(checkLocation)) {
            checkStmt.setInt(1, event.getLocation().getIdLocation());
            checkStmt.setTimestamp(2, Timestamp.valueOf(event.getDateTimeEvent()));
            checkStmt.setTimestamp(3, Timestamp.valueOf(event.getDateTimeEndEvent()));
            checkStmt.setTimestamp(4, Timestamp.valueOf(event.getDateTimeEvent()));
            checkStmt.setTimestamp(5, Timestamp.valueOf(event.getDateTimeEndEvent()));
            checkStmt.setTimestamp(6, Timestamp.valueOf(event.getDateTimeEvent()));
            checkStmt.setTimestamp(7, Timestamp.valueOf(event.getDateTimeEndEvent()));

            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt("count") > 0) {
                throw new IllegalStateException("There is already an event at this location that overlaps with the selected time.");
            }
        }
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, event.getName());
            stmt.setString(2, event.getDescription());
            stmt.setTimestamp(3, Timestamp.valueOf(event.getDateTimeEvent()));
            stmt.setInt(4, event.getLocation().getIdLocation());
            stmt.setInt(5, event.getDuration());
            stmt.setString(6, event.getSponsor());
            stmt.setString(7, event.getType());
            stmt.setString(8, event.getClassification());
            stmt.setInt(9, event.getParticipantsNumbers());
            stmt.setInt(10, event.getArtist().getIdArtist());
            stmt.setTimestamp(11, Timestamp.valueOf(event.getDateTimeEndEvent()));
            stmt.setString(12, "1");
            stmt.executeUpdate();

            //ID event
            ResultSet rs = stmt.getGeneratedKeys();
            int eventId = 0;
            if (rs.next()) {
                eventId = rs.getInt(1);
            }
            String sqlInvited = Insert.INSERT_INVITED.getQuery();
            for (Artist artist : event.getInvitedArtist()) {
                PreparedStatement stmtInvited = Database.connection().prepareStatement(sqlInvited);
                stmtInvited.setInt(1, eventId);
                stmtInvited.setInt(2, artist.getIdArtist());
                stmtInvited.executeUpdate();
            }
            tdao.saveTicket(eventId, ticket);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Can't create event: " + e.getMessage());
        }
    }

    public boolean editEvent(Event event) throws SQLException {
        String sql = Update.UPDATE_EVENT.getQuery();
        boolean edit = false;
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, event.getName());
            stmt.setString(2, event.getDescription());
            stmt.setInt(3, event.getDuration());
            stmt.setString(4, event.getSponsor());
            stmt.setString(5, event.getClassification());
            stmt.setTimestamp(6, Timestamp.valueOf(event.getDateTimeEvent()));
            stmt.setInt(7, event.getIdEvent());
            stmt.executeUpdate();
            ArtistDAO.deleteInvitedArtist(event.getIdEvent());
            String sqlInvited = Insert.INSERT_INVITED.getQuery();
            for (Artist artist : event.getInvitedArtist()) {
                PreparedStatement stmtInvited = Database.connection().prepareStatement(sqlInvited);
                stmtInvited.setInt(1, event.getIdEvent());
                stmtInvited.setInt(2, artist.getIdArtist());
                stmtInvited.executeUpdate();
            }
            edit = true;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Can't edit event: " + e.getMessage());
        }
        return edit;
    }

    public List<Event> getAllEventNotCancelledOrFinished() throws SQLException {
        String sql = Select.SELECT_EVENT.getQuery();
        List<Event> events = new ArrayList<>();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Event event = new Event();
                event.setIdEvent(rs.getInt("id_event"));
                event.setName(rs.getString("name"));
                event.setDescription(rs.getString("description"));
                event.setDateTimeEvent(rs.getTimestamp("date_event").toLocalDateTime());
                event.setStatusEvent(rs.getString("status_event"));
                event.setClassification(rs.getString("classification"));
                event.setSponsor(rs.getString("sponsor"));
                event.setParticipantsNumbers(rs.getInt("participants_numbers"));
                event.setDuration(rs.getInt("duration"));

                int locationId = rs.getInt("location_id");
                Location location = LocationDAO.viewLocationDetail(locationId);
                event.setLocation(location);

                int artistId = rs.getInt("artist_id");
                Artist mainArtist = ArtistDAO.viewArtistDetail(artistId);
                event.setArtist(mainArtist);

                List<Artist> invited = ArtistDAO.getInvitedArtistsByEvent(event.getIdEvent());
                event.setInvitedArtist(invited);

                events.add(event);
            }
        }
        return events;
    }

    public Event consultEventById(int idEvent) throws SQLException {
        String sql = Select.SELECT_EVENT_SPECIFIC.getQuery();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setInt(1, idEvent);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                return null;
            } else {
                Location location = new Location(
                        rs.getString("location_name"),
                        rs.getString("location_address"),
                        rs.getString("city"),
                        rs.getString("department"),
                        rs.getString("type_location"),
                        rs.getInt("capacity"),
                        rs.getBoolean("availability"),
                        rs.getDouble("price_location"),
                        rs.getString("consideration"),
                        rs.getInt("id_location")
                );

                Artist mainArtist = new Artist(
                        rs.getInt("principal_artist_id"),
                        rs.getDouble("price_artist"),
                        rs.getString("principal_artist_name")
                );
                System.out.println("Artista " + mainArtist.getArtisticName());

                Event event = new Event(
                        rs.getString("event_name"),
                        rs.getString("event_description"),
                        rs.getTimestamp("date_event").toLocalDateTime(),
                        location,
                        rs.getInt("duration"),
                        rs.getString("sponsor"),
                        rs.getString("classification"),
                        rs.getInt("participants_number"),
                        mainArtist,
                        EventDAO.getInvitedArtists(idEvent),
                        rs.getString("type"),
                        rs.getString("status_event")
                );
                event.setIdEvent(idEvent);
                event.setGenre(rs.getString("genre_topic"));
                event.setTickets(EventDAO.getTicketsByEventId(idEvent));
                return event;
            }
        }
    }

}
