/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.event.master.pro.event.Concert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.event.master.pro.event.Event.Event;
import org.event.master.pro.event.Event.EventDAO;
import static org.event.master.pro.event.Event.EventDAO.*;
import org.event.master.pro.event.location.Location;
import org.event.master.pro.event.location.LocationDAO;
import org.event.master.pro.event.ticket.Ticket;
import org.event.master.pro.event.ticket.TicketDAO;
import org.event.master.pro.person.account.Account;
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
public class ConcertDAO {

    public void saveConcert(Concert concert, List<Ticket> ticket) throws SQLException {
        String checkLocation = Select.SELECT_COUNT_LOCATION_OCCUPED.getQuery();
        String sql = Insert.INSERT_EVENT.getQuery();
        TicketDAO tdao = new TicketDAO();

        try (PreparedStatement checkStmt = Database.connection().prepareStatement(checkLocation)) {
            checkStmt.setInt(1, concert.getLocation().getIdLocation());
            checkStmt.setTimestamp(2, Timestamp.valueOf(concert.getDateTimeEvent()));      // new start
            checkStmt.setTimestamp(3, Timestamp.valueOf(concert.getDateTimeEndEvent()));   // new end
            checkStmt.setTimestamp(4, Timestamp.valueOf(concert.getDateTimeEvent()));      // new start
            checkStmt.setTimestamp(5, Timestamp.valueOf(concert.getDateTimeEndEvent()));   // new end
            checkStmt.setTimestamp(6, Timestamp.valueOf(concert.getDateTimeEvent()));      // new start
            checkStmt.setTimestamp(7, Timestamp.valueOf(concert.getDateTimeEndEvent()));   // new end

            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt("count") > 0) {
                throw new IllegalStateException("There is already an event at this location that overlaps with the selected time.");
            }
        }
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, concert.getName());
            stmt.setString(2, concert.getDescription());
            stmt.setTimestamp(3, Timestamp.valueOf(concert.getDateTimeEvent()));
            stmt.setInt(4, concert.getLocation().getIdLocation());
            stmt.setInt(5, concert.getDuration());
            stmt.setString(6, concert.getSponsor());
            stmt.setString(7, concert.getType());
            stmt.setString(8, concert.getClassification());
            stmt.setInt(9, concert.getParticipantsNumbers());
            stmt.setInt(10, concert.getArtist().getIdArtist());
            stmt.setTimestamp(11, Timestamp.valueOf(concert.getDateTimeEndEvent()));
            stmt.setString(12, "1");
            stmt.executeUpdate();

            //ID concert
            ResultSet rs = stmt.getGeneratedKeys();
            int concertId = 0;
            if (rs.next()) {
                concertId = rs.getInt(1);
            }
            String sqlInvited = Insert.INSERT_INVITED.getQuery();
            for (Artist artist : concert.getInvitedArtist()) {
                PreparedStatement stmtInvited = Database.connection().prepareStatement(sqlInvited);
                stmtInvited.setInt(1, concertId);
                stmtInvited.setInt(2, artist.getIdArtist());
                stmtInvited.executeUpdate();
            }
            tdao.saveTicket(concertId, ticket);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Can't create event: " + e.getMessage());
        }
    }

    public boolean editConcert(Concert concert) throws SQLException {
        String sql = Update.UPDATE_EVENT.getQuery();
        boolean edit = false;
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, concert.getName());
            stmt.setString(2, concert.getDescription());
            stmt.setInt(3, concert.getDuration());
            stmt.setString(4, concert.getSponsor());
            stmt.setString(5, concert.getClassification());
            stmt.setTimestamp(6, Timestamp.valueOf(concert.getDateTimeEvent()));
            stmt.setInt(7, concert.getIdEvent());
            stmt.executeUpdate();
            ArtistDAO.deleteInvitedArtist(concert.getIdEvent());
            String sqlInvited = Insert.INSERT_INVITED.getQuery();
            for (Artist artist : concert.getInvitedArtist()) {
                PreparedStatement stmtInvited = Database.connection().prepareStatement(sqlInvited);
                stmtInvited.setInt(1, concert.getIdEvent());
                stmtInvited.setInt(2, artist.getIdArtist());
                stmtInvited.executeUpdate();
            }
            edit = true;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Can't create event: " + e.getMessage());
        }
        return edit;
    }

    public List<Concert> consultConcert(String status) {
        LocationDAO l = new LocationDAO();
        String sql = Select.SELECT_EVENTS_INFO.getQuery();
        List<Concert> concert = new ArrayList<Concert>();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setString(1, "concert");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int eventId = rs.getInt("e.id_event");
                String name = rs.getString("event_name");
                LocalDateTime date = rs.getTimestamp("e.date_event").toLocalDateTime();
                //String address = rs.getString("l.address");
                String type = rs.getString("type_location");
                String description = rs.getString("e.description");
                //String invitedArtist = rs.getString("invited_artist");
                List<Artist> invitedArtistList = new ArtistDAO().getInvitedArtistsByEvent(eventId);
                Location location = new Location(rs.getString("location_name"), rs.getInt("l.id_location"));
                Concert c = new Concert(name, description, date, type, location, invitedArtistList);
                concert.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL Error: " + e.getMessage());
        }
        return concert;

    }

    public List<Concert> getAllEventNotCancelledOrFinished() throws SQLException {
        String sql = Select.SELECT_EVENT.getQuery();
        List<Concert> concerts = new ArrayList<>();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Concert concert = new Concert();
                concert.setIdEvent(rs.getInt("id_event"));
                concert.setName(rs.getString("name"));
                concert.setDescription(rs.getString("description"));
                concert.setDateTimeEvent(rs.getTimestamp("date_event").toLocalDateTime());
                concert.setStatusEvent(rs.getString("status_event"));
                concert.setClassification(rs.getString("classification"));
                concert.setSponsor(rs.getString("sponsor"));
                concert.setParticipantsNumbers(rs.getInt("participants_numbers"));
                concert.setDuration(rs.getInt("duration"));

                int locationId = rs.getInt("location_id");
                Location location = LocationDAO.viewLocationDetail(locationId);
                concert.setLocation(location);

                int artistId = rs.getInt("artist_id");
                Artist mainArtist = ArtistDAO.viewArtistDetail(artistId);
                concert.setArtist(mainArtist);

                List<Artist> invited = ArtistDAO.getInvitedArtistsByEvent(concert.getIdEvent());
                concert.setInvitedArtist(invited);
                // event.setFinance(financeDAO.getFinanceByEventId(event.getId()));

                concerts.add(concert);
            }
        }
        return concerts;
    }

    public Concert consultConcertById(int idEvent) throws SQLException {
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

                Concert concert = new Concert(
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
                        rs.getString("type")
                );
                concert.setIdEvent(idEvent);
                concert.setGenre(rs.getString("genre_topic"));
                concert.setTickets(EventDAO.getTicketsByEventId(idEvent));

                return concert;
            }
        }
    }
}
