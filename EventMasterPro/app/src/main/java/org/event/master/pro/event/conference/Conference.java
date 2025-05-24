package org.event.master.pro.event.conference;

import org.event.master.pro.event.Event.Event;
import org.event.master.pro.event.Event.IEvent;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.event.master.pro.event.location.Location;
import org.event.master.pro.event.ticket.Ticket;

import static org.event.master.pro.util.Util.*;

public class Conference extends Event{
    private String speaker;
    private String conferenceTopic;
    private int day;
    private List<Ticket> ticket;

    public Conference(){}

   /* public Conference(String speaker, String conferenceTopic, int day, String name, String description, LocalDateTime dateTimeEvent,  String statusEvent, Location location, int duration, String sponsor, String classification, int participantsNumbers, List<Ticket> ticket) {
        super(name, description, dateTimeEvent, statusEvent, location, duration, sponsor, classification, participantsNumbers);
        this.speaker = speaker;
        this.conferenceTopic = conferenceTopic;
        this.day = day;
        this.ticket = ticket;
    }
*/
    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getConferenceTopic() {
        return conferenceTopic;
    }

    public void setConferenceTopic(String conferenceTopic) {
        this.conferenceTopic = conferenceTopic;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}