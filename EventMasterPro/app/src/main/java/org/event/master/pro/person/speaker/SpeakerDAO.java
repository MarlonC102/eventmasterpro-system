/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.event.master.pro.person.speaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
public class SpeakerDAO {

    public List<Speaker> consultSpeaker() {
        String sql = Select.SELECT_ARTIST.getQuery();
        List<Speaker> speaker = new ArrayList<Speaker>();

        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setBoolean(1, false);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String speciality = rs.getString("genre_topic");
                double price = rs.getDouble("price_artist");
                String documentNumber = rs.getString("document_number");
                boolean availability = rs.getBoolean("availability");
                int idSpeaker = rs.getInt("id_artist");
                Speaker s = new Speaker(documentNumber, name, price, availability, speciality, idSpeaker);
                speaker.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error SQL: " + e.getMessage());
        }
        return speaker;
    }

    public int countAllSpeaker() {
        int locationActive = 0;
        String sql = Select.COUNT_ACTIVE_SPEAKER.getQuery();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                locationActive = rs.getInt("total_speaker");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error SQL: " + e.getMessage());
        }
        return locationActive;
    }

    public List<Speaker> viewSpeakerDetail(String document) {
        String sql = Select.SELECT_SPECIFIC_ARTIST_BY_DOC.getQuery();
        List<Speaker> speaker = new ArrayList<Speaker>();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setString(1, document);
            stmt.setBoolean(2, false);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String documentNumber = rs.getString("document_number");
                String name = rs.getString("name");
                String musicalGenre = rs.getString("genre_topic");
                double price = rs.getDouble("price_artist");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phone_number");
                String requirements = rs.getString("requirements");
                DecimalFormat formatter = new DecimalFormat("#,###.##");
                boolean availability = rs.getBoolean("availability");
                Speaker s = new Speaker(documentNumber, name, email, phoneNumber, requirements, price, musicalGenre, availability);
                speaker.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error SQL: " + e.getMessage());
        }
        return speaker;
    }

    public static Speaker viewSpeakerDetail(int id) {
        String sql = Select.SELECT_SPECIFIC_ARTIST.getQuery();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setBoolean(2, false);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String documentNumber = rs.getString("document_number");
                String name = rs.getString("name");
                String musicalGenre = rs.getString("genre_topic");
                double price = rs.getDouble("price_artist");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phone_number");
                String requirements = rs.getString("requirements");
                DecimalFormat formatter = new DecimalFormat("#,###.##");
                boolean availability = rs.getBoolean("availability");
                return new Speaker(documentNumber, name, email, phoneNumber, requirements, price, musicalGenre, availability);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL Error: " + e.getMessage());
        }
        return null;
    }

    public void editSpeaker(List<Speaker> speaker) {
        String sql = Update.UPDATE_ARTIST_P1.getQuery();
        String sql2 = Update.UPDATE_ARTIST_P2.getQuery();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            try (PreparedStatement stmt2 = Database.connection().prepareStatement(sql2)) {
                for (Speaker s : speaker) {
                    stmt.setString(1, s.getRequirements());
                    stmt.setDouble(2, s.getPrice());
                    stmt.setString(3, s.getSpeciality());
                    stmt.setString(4, s.getDocumenNumber().toString());
                    stmt2.setString(1, s.getName());
                    stmt2.setString(2, s.getMail());
                    stmt2.setString(3, s.getPhone());
                    stmt2.setString(4, s.getDocumenNumber().toString());
                }
                stmt.executeUpdate();
                stmt2.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Error SQL: " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error SQL: " + e.getMessage());
        }
    }

    /*public void changeStatusSpeaker(String document) {
        String mainArtist = Select.SELECT_COUNT_MAIN_ARTIST.getQuery();
        String invitedArtist = Select.SELECT_COUNT_INVIDET_ARTIST.getQuery();
        String sql = Update.CHANGE_STATUS_ARTIST.getQuery();
        int principalCount = 0;
        int invitedCount = 0;
        try (PreparedStatement maintStmt = Database.connection().prepareStatement(mainArtist); 
             PreparedStatement invitedStmt = Database.connection().prepareStatement(invitedArtist); 
             PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            maintStmt.setString(1, document);
            invitedStmt.setString(1, document);

            try (ResultSet rs = maintStmt.executeQuery()) {
                if (rs.next()) {
                    principalCount = rs.getInt("count");
                }
            }

            try (ResultSet rs = invitedStmt.executeQuery()) {
                if (rs.next()) {
                    invitedCount = rs.getInt("count");
                }
            }

            if (principalCount > 0 || invitedCount > 0) {
                throw new IllegalStateException("Cannot deactivate artist. The artist is still linked to active events.");
            }
            stmt.setBoolean(1, false);
            stmt.setString(2, document);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error SQL: " + e.getMessage());
        }
    }
*/
    public boolean registerSpeaker(String documentType, String documentNumber, String name, String mail, String speciality, String phoneNumber, String requirements, double price) {
        String sql = Select.CONSULT_DOCUMENT_NUMBER.getQuery();
        String insertPerson = Insert.INSERT_PERSON.getQuery();
        String insertArtist = Insert.INSERT_ARTIST.getQuery();
        boolean message = true;
        try (Connection conn = Database.connection()) {
            try (PreparedStatement sql1 = conn.prepareStatement(sql)) {
                sql1.setString(1, documentNumber);
                ResultSet rs = sql1.executeQuery();
                if (!rs.next()) {
                    try (PreparedStatement stmt = conn.prepareStatement(insertPerson)) {
                        stmt.setString(1, documentType);
                        stmt.setString(2, documentNumber);
                        stmt.setString(3, name);
                        stmt.setString(4, mail);
                        stmt.setString(5, phoneNumber);
                        stmt.executeUpdate();
                        try (PreparedStatement stmt2 = conn.prepareStatement(insertArtist)) {
                            stmt2.setString(1, requirements);
                            stmt2.setString(2, speciality);
                            stmt2.setDouble(3, price);
                            stmt2.setString(4, documentNumber);
                            stmt2.setBoolean(5, false);
                            stmt2.executeUpdate();
                            message = false;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error SQL: " + e.getMessage());
        }
        return message;
    }
}
