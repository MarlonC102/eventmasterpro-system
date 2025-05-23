/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.event.master.pro.event.Event;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.event.master.pro.util.Database;
import org.event.master.pro.util.sql.Insert;
import org.event.master.pro.util.sql.Select;

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
    
   
    
    
}
