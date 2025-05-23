/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.event.master.pro.person.artist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import org.event.master.pro.util.Database;
import org.event.master.pro.util.sql.Insert;
import org.event.master.pro.util.sql.Select;
import org.event.master.pro.util.sql.Update;

/**
 *
 * @author Luisa
 */
public class ArtistDAO {
        
    public int countAllArtist(){
        int locationActive = 0;
        String sql = Select.COUNT_ACTIVE_ARTIST.getQuery();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                locationActive = rs.getInt("total_artist");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error SQL: " + e.getMessage());
        }
        return locationActive;
    }
     
    public List<Artist> consultArtist(){
        String sql = Select.SELECT_ARTIST.getQuery();
        List<Artist> artist = new ArrayList<Artist>();
        
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setBoolean(1, true);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String genre = rs.getString("genre_topic");
                double price = rs.getDouble("price_artist");
                String documentType = rs.getString("document_type");
                String documentNumber = rs.getString("document_number");
                boolean availability = rs.getBoolean("availability");
                String idArtist = rs.getString("id_artist");
                Artist a = new Artist(documentType, documentNumber, name, genre, price, availability, idArtist);
                artist.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error SQL: " + e.getMessage());
        } return artist;
    } 
    
    public List<Artist> viewArtistDetail(String document){
        String sql = Select.SELECT_SPECIFIC_ARTIST.getQuery();
        List<Artist> artist = new ArrayList<Artist>();
       try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
           stmt.setString(1, document);
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
                Artist a = new Artist(documentNumber, name, email, phoneNumber,requirements, price, musicalGenre,availability);
                artist.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error SQL: " + e.getMessage());
        } return artist;
    }
    
    
    public void editArtist(List<Artist> artist){
        String sql = Update.UPDATE_ARTIST_P1.getQuery();
        String sql2 = Update.UPDATE_ARTIST_P2.getQuery();
       try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
           try(PreparedStatement stmt2 = Database.connection().prepareStatement(sql2)){
            for (Artist a : artist) {
                stmt.setString(1, a.getRequirements());
                stmt.setDouble(2, a.getPrice());
                stmt.setString(3, a.getGenre());
                stmt.setString(4, a.getDocumenNumber().toString());
                stmt2.setString(1, a.getName());
                stmt2.setString(2, a.getMail());
                stmt2.setString(3, a.getPhone());
                stmt2.setString(4, a.getDocumenNumber().toString());
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
    
    public void changeStatusArtist(String document){
        String sql = Update.CHANGE_STATUS_ARTIST.getQuery();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
                stmt.setBoolean(1, false);
                stmt.setString(2, document);
            stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error SQL: " + e.getMessage());
        }
    }
    
    public boolean registerArtist(String aDocumentType, String aDocumentNumber, String aName, String aMail, String aMusicalGenre, String aPhoneNumber, String aRequirements, double aPrice){
        String sql = Select.CONSULT_DOCUMENT_NUMBER.getQuery();
        String insertPerson = Insert.INSERT_PERSON.getQuery();
        String insertArtist = Insert.INSERT_ARTIST.getQuery();
        boolean message = true;
        try(Connection conn = Database.connection()){
            try (PreparedStatement sql1 = conn.prepareStatement(sql)) {
                sql1.setString(1, aDocumentNumber);
                ResultSet rs = sql1.executeQuery();
                 if (!rs.next()) {
                    try (PreparedStatement stmt = conn.prepareStatement(insertPerson)) {
                    stmt.setString(1, aDocumentType);
                    stmt.setString(2, aDocumentNumber);
                    stmt.setString(3, aName);
                    stmt.setString(4, aMail);
                    stmt.setString(5, aPhoneNumber);
                    stmt.executeUpdate();
                        try (PreparedStatement stmt2 = conn.prepareStatement(insertArtist)) {
                            stmt2.setString(1, aRequirements);
                            stmt2.setString(2, aMusicalGenre);
                            stmt2.setDouble(3, aPrice);
                            stmt2.setString(4, aDocumentNumber);
                            stmt2.setBoolean(5, true);
                            stmt2.executeUpdate();
                            message = false;
                        }
                    }
                }
            }    
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error SQL: " + e.getMessage());
        } return message;
    } 

    
}
