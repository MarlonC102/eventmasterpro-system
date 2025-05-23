/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.event.master.pro.event.Concert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.event.master.pro.event.location.Location;
import org.event.master.pro.event.location.LocationDAO;
import org.event.master.pro.event.ticket.Ticket;
import org.event.master.pro.event.ticket.TicketDAO;
import org.event.master.pro.person.account.Account;
import org.event.master.pro.util.Database;
import org.event.master.pro.util.sql.Insert;
import org.event.master.pro.util.sql.Select;

/**
 *
 * @author Luisa
 */
public class ConcertDAO {
     public void saveConcert(Concert concert, List<Ticket> ticket) throws SQLException {
            String sql = Insert.INSERT_EVENT.getQuery();
            Account a = new Account();
            TicketDAO tdao = new TicketDAO();
            try (PreparedStatement stmt = Database.connection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, concert.getName());
                stmt.setString(2, concert.getDescription());
                stmt.setTimestamp(3, Timestamp.valueOf(concert.getDateTimeEvent()));
                stmt.setString(4, concert.getLocation().getIdLocation());
                stmt.setInt(5, concert.getDuration());
                stmt.setString(6, concert.getSponsor());
                stmt.setString(7, concert.getType());
                stmt.setString(8, concert.getClassification());
                stmt.setInt(9, concert.getParticipantsNumbers());
                stmt.setString(10, concert.getArtist().getIdArtist());
                stmt.setString(11, "3");
                stmt.executeUpdate();
            
            

            //ID concert
            ResultSet rs = stmt.getGeneratedKeys();
            int concertId = 0;
            if (rs.next()) {
                concertId = rs.getInt(1);
            }
            String sqlInvited = Insert.INSERT_INVITED.getQuery();
            for (String idArtist : concert.getInvitedArtist()) {
                PreparedStatement stmtInvited = Database.connection().prepareStatement(sqlInvited);
                stmtInvited.setInt(1, concertId);
                stmtInvited.setString(2, idArtist);
                System.out.println(stmtInvited);
                stmtInvited.executeUpdate();
            }
            tdao.saveTicket(concertId, ticket);
            
        }catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Can't create event: " + e.getMessage());
        }
     }
      public List<Concert> consultConcert(String status){
          LocationDAO l = new LocationDAO();
        String sql = Select.SELECT_EVENTS_INFO.getQuery();
        List<Concert> concert = new ArrayList<Concert>();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setString(1, "concert");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("event_name");
                LocalDateTime date = rs.getTimestamp("e.date_event").toLocalDateTime();
                String address = rs.getString("l.address");
                String type = rs.getString("type_location");
                String description = rs.getString("e.description");
                String invitedArtist = rs.getString("invited_artist");
                List<String> invitedArtistList = Arrays.asList(invitedArtist.split(",\\s*"));
                Location location = new Location(rs.getString("location_name"),rs.getString("l.id_location").toString());
                Concert c = new Concert(name, description, date, type, location, invitedArtistList);
                concert.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error SQL: " + e.getMessage());
        }return concert;
        
    }
}
