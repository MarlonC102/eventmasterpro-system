package org.event.master.pro.event.Event;

import org.event.master.pro.enums.EventStatus;
import org.event.master.pro.enums.EventZone;
import org.event.master.pro.util.Util;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.event.master.pro.event.location.Location;
import org.event.master.pro.event.ticket.Ticket;

import static org.event.master.pro.util.Util.*;

public abstract class Event{
    private int idEvent;
    private static String id;
    private String name;
    private String description;
    private LocalDateTime dateTimeEvent;
    private String statusEvent;
    private String type; 
    private Location location;
    private int duration;
    private String sponsor;
    private String classification;
    private int participantsNumbers;
    private int currentParticipants;
    private List<Ticket> tickets = new ArrayList<>();

    public Event() {
    }
    
    public Event(String name, String description, LocalDateTime dateTimeEvent, String type, Location location){
        this.name = name;
        this.description = description;
        this.dateTimeEvent = dateTimeEvent;
        this.type = type;
        this.location = location;
    }

    public Event(String name, String description, LocalDateTime dateTimeEvent, Location location, int duration, String sponsor, String classification, int participantsNumbers, String type) {
        this.name = name;
        this.description = description;
        this.dateTimeEvent = dateTimeEvent;
        this.location = location;
        this.duration = duration;
        this.sponsor = sponsor;
        this.classification = classification;
        this.participantsNumbers = participantsNumbers;
        this.type = type;

    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTimeEvent() {
        return dateTimeEvent;
    }

    public void setDateTimeEvent(LocalDateTime dateTimeEvent) {
        this.dateTimeEvent = dateTimeEvent;
    }
    public String getStatusEvent() {
        return statusEvent;
    }

    public void setStatusEvent(String statusEvent) {
        this.statusEvent = statusEvent;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public int getParticipantsNumbers() {
        return participantsNumbers;
    }

    public void setParticipantsNumbers(int participantsNumbers) {
        this.participantsNumbers = participantsNumbers;
    }

    public int getCurrentParticipants() {
        return currentParticipants;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}


