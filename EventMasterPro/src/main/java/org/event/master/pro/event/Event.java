package org.event.master.pro.event;

import org.event.master.pro.enums.EventStatus;
import org.event.master.pro.enums.EventZone;
import org.event.master.pro.util.Util;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.event.master.pro.util.Util.*;

public abstract class Event {
    private int idEvent;
    private String name;
    private String description;
    private Date dateEvent;
    private Time timeEvent;
    private String statusEvent;
    private Location location;
    private int duration;
    private String sponsor;
    private String classification;
    private int participantsNumbers;
    private int currentParticipants;
    private static int id = 1;
    private List<Ticket> ticketsSold = new ArrayList<>();

    public Event() {
        idEvent = id++;
    }

    public Event(String name, String description, Date dateEvent, Time timeEvent, String statusEvent, Location location, int duration, String sponsor, String classification, int participantsNumbers) {
        this.idEvent = id++;
        this.name = name;
        this.description = description;
        this.dateEvent = dateEvent;
        this.timeEvent = timeEvent;
        this.statusEvent = statusEvent;
        this.location = location;
        this.duration = duration;
        this.sponsor = sponsor;
        this.classification = classification;
        this.participantsNumbers = participantsNumbers;

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

    public Date getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
    }

    public Time getTimeEvent() {
        return timeEvent;
    }

    public void setTimeEvent(Time timeEvent) {
        this.timeEvent = timeEvent;
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

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Event.id = id;
    }

    public int getCurrentParticipants() {
        return currentParticipants;
    }

    public abstract Event createEvent(List<Location> loc);

    public abstract Event updateEvent(List<Location> locations);

    public abstract void consultEvent(Event event);

    public abstract Event consultSpecificEvent(List<Event> event);

   /* public Ticket generateTicket(Customer customer) {
        if (Ticket.getMaxTickets() < participantsNumbers) {
            Ticket ticket = new Ticket(this, customer);
            printMessage("Ticket purchased successfully!");
            return ticket;
        } else {
            printMessage("Sorry, no more tickets available for this event.");
            return null;
        }
    }
*/

    public Location selectLocation(List<Location> locations) {
        String locationEvent = null;
        boolean find;
        do {
            locationEvent = strigsInput("Choose a location for the event:");
            if (Location.consultSpecificLocation(locationEvent, locations) != null) {
                return Location.consultSpecificLocation(locationEvent, locations);
            } else {
                find = false;
            }
        } while (find != true);
        return null;
    }

    public int valideQuorum(Location locations) {
        participantsNumbers = intInput("Enter the maximum number of people that you expect to attend the event");
        while (participantsNumbers > locations.getCapacity()) {
            participantsNumbers = Util.intInput("Quorum must be less than or equal to the capacity of the event site");
        }
        return participantsNumbers;
    }

    public void incrementCurrentParticipants() {
        if (this.currentParticipants < this.participantsNumbers) {
            this.currentParticipants++;
        }
    }

    public List<Ticket> getTicketsSold() {
        return ticketsSold;
    }



    public Event changeStatusEvent(Event event) {
        int newStatusEvent;
        printMessage("""
                -------------Select status-------------
                1. Created
                2. Published
                3. In Progress
                4. Rescheduled
                5. Finished
                6. Cancelled
                7. Exit
                --------------------------------------------""");
        newStatusEvent = intInput("Enter the new status");

        if (event.getStatusEvent().equalsIgnoreCase(EventStatus.CANCELLED.getEventStatus()) ||
                event.getStatusEvent().equalsIgnoreCase(EventStatus.FINISHED.getEventStatus())) {
            printMessage("Cannot change the status, the event is already 'Canceled' or 'Finished'.");
            return event;
        }
        if (event.getStatusEvent().equalsIgnoreCase(EventStatus.PUBLISHED.getEventStatus()) && (newStatusEvent == 1 || newStatusEvent == 2)) {
            printMessage("Cannot change an event from 'Published' to 'Created' or 'Published'.");
            return event;
        }
        if (event.getStatusEvent().equalsIgnoreCase(EventStatus.IN_PROGRESS.getEventStatus())
                && (newStatusEvent == 1 || newStatusEvent == 2 || newStatusEvent == 3)) {
            printMessage("You can only change an event from 'In Progress' to 'Rescheduled', 'Finished' or 'Cancelled'.");
            return event;
        }
        if (event.getStatusEvent().equalsIgnoreCase(EventStatus.RESCHEDULED.getEventStatus()) && (newStatusEvent == 1 || newStatusEvent == 4)) {
            printMessage("Cannot change an event from 'Rescheduled' to 'Created' or 'Rescheduled'");
            return event;
        }

        switch (newStatusEvent) {
            case 1:
                event.setStatusEvent(EventStatus.CREATED.getEventStatus());
                break;
            case 2:
                event.setStatusEvent(EventStatus.PUBLISHED.getEventStatus());
                break;
            case 3:
                event.setStatusEvent(EventStatus.IN_PROGRESS.getEventStatus());
                break;
            case 4:
                event.setStatusEvent(EventStatus.RESCHEDULED.getEventStatus());
                break;
            case 5:
                event.setStatusEvent(EventStatus.FINISHED.getEventStatus());
                break;
            case 6:
                event.setStatusEvent(EventStatus.CANCELLED.getEventStatus());
                break;
            case 7:
                printMessage("Status has not been changed");
                break;
            default:
                printMessage("Wrong status!");
                break;
        }
        return this;
    }

    public String selectZone() {
        printMessage("-------------Select status-------------\n" +
                "1. " + EventZone.VIPN.getDescription() + ": " + EventZone.VIP.getDescription() + "\n" +
                "2. " + EventZone.GENERALN.getDescription() + ": " + EventZone.GENERAL.getDescription() + "\n" +
                "3. " + EventZone.PREFERENTIALN.getDescription() + ": " + EventZone.PREFERENTIAL.getDescription() + "\n" +
                "--------------------------------------------");
        int zoneEvent = intInput("Enter the zone status");
        do {
            switch (zoneEvent){
                case 1:
                    return EventZone.VIPN.getDescription();
                case 2:
                    return EventZone.GENERALN.getDescription();
                case 3:

                    return EventZone.PREFERENTIALN.getDescription();
                default:
                    printMessage("Wrong zone.");
                    break;
            }
        } while (true);
    }
}

