/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.event.master.pro.event.Event;

import java.sql.SQLException;
import java.util.List;
import org.event.master.pro.enums.EventStatus;



/**
 *
 * @author Luisa
 */
public interface IEvent {
    
    int countAllEventsInProgress(String query) throws SQLException;
    void updateEventStatus(int eventId, EventStatus status) throws SQLException;
    //List<Event> getAllEventNotCancelledOrFinished() throws SQLException;
}
