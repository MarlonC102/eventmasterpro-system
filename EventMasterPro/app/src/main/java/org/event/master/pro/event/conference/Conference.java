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
import static org.event.master.pro.util.Util.strigsInput;

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

    public Conference createEvent(List<Location> loc) {
        Conference conference = new Conference();
        conference.setName(strigsInput("Enter conference name: "));
        conference.setDescription(strigsInput("Enter description: "));
        conference.setStatusEvent("Created");
        //conference.setLocation(selectLocation(loc));
        conference.setDuration(intInput("Enter event duration (hours): "));
        conference.setSponsor(strigsInput("Enter sponsor name: "));
        conference.setClassification(strigsInput("Enter classification: "));
        //conference.setParticipantsNumbers(valideQuorum(conference.getLocation()));
        conference.setDay(intInput("Enter the number of days the conference lasts: "));
        conference.setSpeaker(strigsInput("Enter main speaker: "));
        conference.setConferenceTopic(strigsInput("Enter conference topic: "));
        //conference.setDateEvent(inputDate("Enter event date (yyyy-MM-dd): "));
        //conference.setTimeEvent(inputTime("Enter event time (HH:mm): "));
        printMessage("Conference created!");
        return conference;
    }

    public Conference updateEvent(List<Location> locations) {
        printMessage("Conference found. Enter new values:");
        this.setDescription(strigsInput("Enter new description: "));
        //this.setDateEvent(inputDate("Enter new date (yyyy-MM-dd): "));
        //this.setTimeEvent(inputTime("Enter new time (HH:mm): "));
        //this.setLocation(selectLocation(locations));
        this.setDuration(intInput("Enter new duration (hours): "));
        this.setSponsor(strigsInput("Enter new sponsor: "));
        this.setClassification(strigsInput("Enter new classification: "));
        this.setParticipantsNumbers(intInput("Enter new number of participants: "));
        this.setDay(intInput("Enter new number of days: "));
        this.setSpeaker(strigsInput("Enter new speaker name: "));
        this.setConferenceTopic(strigsInput("Enter new conference topic: "));
        Ticket.setMaxTickets(this.getParticipantsNumbers());
        printMessage("Conference updated successfully!");
        return this;
    }

    public void consultEvent(Event conference) {
        if (conference != null) {
            printMessage(String.format("""
                ----- Conference -----
                Event Name: %s
                Date: %s
                """,conference.getName()));
        } else {
            printMessage("No concerts to show.");
        }
    }

    public Event consultSpecificEvent(List<Event> festival){
        String data = strigsInput("Enter the name of concert");
        if (festival != null) {
            for (Event festivals : festival) {
                if (festivals.getName().toLowerCase().equals(data.toLowerCase())) {
                    printMessage(festivals.toString());
                    return festivals;
                }
            }
        } else {
            return null;
        }
        return null;
    }

    /*@Override
    public void generateTicket() {
    }*/

    /*@Override
    public Location selectLocation(List<Location> locations){
        return null;
    }*/

    public void createEvent(List<Event> events, List<Object> specificEvents) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}