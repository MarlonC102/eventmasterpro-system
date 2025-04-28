package org.event.master.pro.event;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import static org.event.master.pro.util.Util.*;

public class Concert extends Event {
    private String artist;
    private String invitedArtist;
    private String genre;

    public Concert() {
    }

    public Concert(String name, String description, Date dateEvent, Time timeEvent, String statusEvent, Location location, int duration, String sponsor, String classification, int participantsNumbers, String artist, String invitedArtist, String genre) {
        super(name, description, dateEvent, timeEvent, statusEvent, location, duration, sponsor, classification, participantsNumbers);
        this.artist = artist;
        this.invitedArtist = invitedArtist;
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getInvitedArtist() {
        return invitedArtist;
    }

    public void setInvitedArtist(String invitedArtist) {
        this.invitedArtist = invitedArtist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public Concert createEvent(List<Location> loc) {
        Concert newConcert = new Concert();
        newConcert.setName(strigsInput("Enter event name: "));
        newConcert.setDescription(strigsInput("Enter description: "));
        newConcert.setStatusEvent("Created");
        newConcert.setLocation(selectLocation(loc));
        newConcert.setDuration(intInput("Enter event duration (hours): "));
        newConcert.setSponsor(strigsInput("Enter sponsor name: "));
        newConcert.setClassification(strigsInput("Enter classification: "));
        newConcert.setParticipantsNumbers(valideQuorum(newConcert.getLocation()));
        newConcert.setArtist(strigsInput("Enter main artist name: "));
        newConcert.setInvitedArtist(strigsInput("Enter invited artist (if any): "));
        newConcert.setGenre(strigsInput("Enter music genre: "));
        newConcert.setDateEvent(inputDate("Enter event date (yyyy-MM-dd): "));
        newConcert.setTimeEvent(inputTime("Enter event time (HH:mm): "));
        Ticket.setMaxTickets(newConcert.getParticipantsNumbers());
        printMessage("Concert created!");
        return newConcert;
    }

    @Override
    public Concert updateEvent(List<Location> locations) {
        printMessage("Concert found. Enter new values:");
        this.setDescription(strigsInput("Enter new description: "));
        this.setDateEvent(inputDate("Enter new date (yyyy-MM-dd): "));
        this.setTimeEvent(inputTime("Enter new time (HH:mm): "));
        this.setLocation(selectLocation(locations));
        this.setDuration(intInput("Enter new duration (hours): "));
        this.setSponsor(strigsInput("Enter new sponsor: "));
        this.setClassification(strigsInput("Enter new classification: "));
        this.setParticipantsNumbers(intInput("Enter new number of participants: "));
        this.setArtist(strigsInput("Enter new main artist: "));
        this.setInvitedArtist(strigsInput("Enter new invited artist (if any): "));
        this.setGenre(strigsInput("Enter new music genre: "));
        Ticket.setMaxTickets(this.getParticipantsNumbers());
        printMessage("Concert updated successfully!");
        return this;
    }

    public void consultEvent(Event concert) {
        if (concert != null) {
            printMessage(String.format("""
                ----- Concert -----
                Event Name: %s
                Date: %s
                """,concert.getName(),concert.getDateEvent()));
        } else {
            printMessage("No concerts to show.");
        }
    }

    public Event consultSpecificEvent(List<Event> concerts){
        String data = strigsInput("Enter the name of concert");
        if (concerts != null) {
            for (Event concert : concerts) {
                if (concert.getName().toLowerCase().equals(data.toLowerCase())) {
                    printMessage(concert.toString());
                    return concert;
                }
            }
        } else {
            return null;
        }
        return null;
    }

    //@Override
    //public void generateTicket() {
    //}


    @Override
    public Location selectLocation(List<Location> locations) {
        String locationEvent = null;
        do {
            locationEvent = strigsInput("Enter the name of the location to select it: ");
            if (Location.consultSpecificLocation(locationEvent, locations) != null) {
                return Location.consultSpecificLocation(locationEvent, locations);
            } else {
                printMessage("Location not found. Please try again.");
            }
        } while (true);
    }

    @Override
    public String toString() {
        return "-------------------------\n" +
                "CONCERT DETAILS\n" +
                "Name: " + getName() + "\n" +
                "Description: " + getDescription() + "\n" +
                "Date: " + getDateEvent() + "\n" +
                "Hour: " + getTimeEvent() + "\n" +
                "Status: " + getStatusEvent() + "\n" +
                "Duration: " + getDuration() + " hours\n" +
                "Sponsor: " + getSponsor() + "\n" +
                "Category: " + getClassification() + "\n" +
                "Number of assistants: " + getParticipantsNumbers() + "\n" +
                "Main artist: " + artist + "\n" +
                "Guest artists: " + invitedArtist + "\n" +
                "Location\n" + getLocation();
    }

}
