/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.event.master.pro.event.location;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.event.master.pro.person.account.Account;
import org.event.master.pro.util.Database;
import org.event.master.pro.util.sql.Insert;
import org.event.master.pro.util.sql.Select;
import org.event.master.pro.util.sql.Update;

/**
 *
 * @author Luisa
 */
public class LocationDAO {

    public boolean registerLocation(String name, String address, String city, String department, String type, String consideration, int capacity, double price) {
        String sql = Insert.INSERT_LOCATION.getQuery();
        Account a = new Account();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setInt(3, capacity);
            stmt.setString(4, city);
            stmt.setString(5, department);
            stmt.setString(6, type);
            stmt.setDouble(7, price);
            stmt.setString(8, consideration);
            stmt.setString(9, a.getId());
            stmt.executeUpdate();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("SQL Error: " + e.getMessage());
        }

    }

    public static List<Location> consultLocation() {
        String sql = Select.SELECT_LOCATION.getQuery();
        List<Location> location = new ArrayList<Location>();

        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setBoolean(1, true);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String department = rs.getString("department");
                String type = rs.getString("type_location");
                int capacity = rs.getInt("capacity");
                boolean availability = rs.getBoolean("availability");
                double price = rs.getDouble("price_location");
                String consideration = rs.getString("consideration");
                int idLocation = rs.getInt("id_location");
                Location l = new Location(name, address, city, department, type, capacity, availability, price, consideration, idLocation);
                location.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL Error: " + e.getMessage());
        }
        return location;
    }

    public static Location viewLocationDetail(String id) {
        String sql = Select.SELECT_SPECIFIC_LOCATION.getQuery();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String address = rs.getString("address");
                int capacity = rs.getInt("capacity");
                String city = rs.getString("city");
                String department = rs.getString("department");
                String type = rs.getString("type_location");
                double price = rs.getDouble("price_location");
                String consideration = rs.getString("consideration");
                boolean availability = rs.getBoolean("availability");
                int idLocation = rs.getInt("id_location");
                return new Location(name, address, city, department, type, capacity, availability, price, consideration, idLocation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL Error: " + e.getMessage());
        }
        return null;
    }

    public static Location viewLocationDetail(int id) {
        String sql = Select.SELECT_SPECIFIC_LOCATION.getQuery();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String address = rs.getString("address");
                int capacity = rs.getInt("capacity");
                String city = rs.getString("city");
                String department = rs.getString("department");
                String type = rs.getString("type_location");
                double price = rs.getDouble("price_location");
                String consideration = rs.getString("consideration");
                boolean availability = rs.getBoolean("availability");
                int idLocation = rs.getInt("id_location");
                return new Location(name, address, city, department, type, capacity, availability, price, consideration, idLocation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL Error: " + e.getMessage());
        }
        return null;
    }

    public void editLocation(List<Location> location, String id) {
        String sql = Update.UPDATE_LOCATION.getQuery();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            for (Location l : location) {
                stmt.setString(1, l.getName());
                stmt.setString(2, l.getAddress());
                stmt.setString(3, l.getCity());
                stmt.setString(4, l.getDepartment());
                stmt.setString(5, l.getType());
                stmt.setInt(6, l.getCapacity());
                stmt.setDouble(7, l.getPrice());
                stmt.setString(8, l.getConsideration());
                stmt.setString(9, id);
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL Error: " + e.getMessage());
        }
    }

    //Por ahora no se usará este método, se reemplazará por changeAvailable, ya que harían lo mismo
    public void assignEvent() {
    }

    public void changeStatusLocation(String id) {
        String checkEvent = Select.SELECT_LOCATION_NOT_FINISHED_CANCELLED.getQuery(); 
        String sql = Update.CHANGE_STATUS_LOCATION.getQuery();
        
        try (PreparedStatement checkStmt = Database.connection().prepareStatement(checkEvent);
                PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            checkStmt.setString(1, id);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt("count") > 0) {
                throw new IllegalStateException("Cannot change status. Some events using this location are still active.");
            }
            stmt.setBoolean(1, false);
            stmt.setString(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL Error: " + e.getMessage());
        }
    }

    public int countAllLocationActive() {
        int locationActive = 0;
        String sql = Select.COUNT_ACTIVE_LOCATION.getQuery();
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                locationActive = rs.getInt("total_location");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL Error: " + e.getMessage());
        }
        return locationActive;
    }
}
