package org.event.master.pro.event.Concert;

import org.event.master.pro.event.Event.Event;
import org.event.master.pro.event.Event.IEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import org.event.master.pro.event.Event.EventDAO;
import org.event.master.pro.event.location.Location;
import org.event.master.pro.event.ticket.Ticket;
import org.event.master.pro.person.artist.Artist;
import org.event.master.pro.util.Database;

import static org.event.master.pro.util.Util.*;
import org.event.master.pro.util.sql.Select;

public class Concert extends Event{
    private Artist artist;
    private HashSet<String> invitedArtist;
    private String genre;
    //private List<Ticket> ticket;
    //private int ticket;

    public Concert() {
    }

    public Concert(String name, String description, LocalDateTime dateTimeEvent, Location location, int duration, String sponsor, String classification, int participantsNumbers, Artist artist, HashSet<String> invitedArtist, String type) {
        super(name, description, dateTimeEvent, location, duration, sponsor, classification, participantsNumbers, type);
        this.artist = artist;
        this.invitedArtist = invitedArtist;
        this.genre = genre;
        //this.ticket = ticket;

    }
    
    public Concert(String name, String description, LocalDateTime date, String type, Location location, List<String>invitedArtist){
        super(name, description, date, type, location);
        this.invitedArtist = (HashSet<String>) invitedArtist;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public HashSet<String> getInvitedArtist() {
        return invitedArtist;
    }

    public void setInvitedArtist(HashSet<String> invitedArtist) {
        this.invitedArtist = invitedArtist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    
    
    
    
    /*@Override    Concert newConcert = new Concert();
        newConcert.setName(strigsInput("Enter event name: "));
        newConcert.setDescription(strigsInput("Enter description: "));
        newConcert.setStatusEvent("Created");
        //newConcert.setLocation(selectLocation(loc));
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
    }*/

    public Concert updateEvent(List<Location> locations) {
        printMessage("Concert found. Enter new values:");
        this.setDescription(strigsInput("Enter new description: "));
        //this.setDateEvent(inputDate("Enter new date (yyyy-MM-dd): "));
        //this.setTimeEvent(inputTime("Enter new time (HH:mm): "));
        //this.setLocation(selectLocation(locations));
        this.setDuration(intInput("Enter new duration (hours): "));
        this.setSponsor(strigsInput("Enter new sponsor: "));
        this.setClassification(strigsInput("Enter new classification: "));
        this.setParticipantsNumbers(intInput("Enter new number of participants: "));
        //this.setArtist(strigsInput("Enter new main artist: "));
        //this.setInvitedArtist(strigsInput("Enter new invited artist (if any): "));
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
                """,concert.getName()));
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
    
    public int countAllEnventInProgress(){
        String sql = Select.SELECT_CONCERT_IN_PROGRESS.getQuery();
        int concertInProgress = 0;
        try (PreparedStatement stmt = Database.connection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                concertInProgress = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error SQL: " + e.getMessage());
        }
        return concertInProgress;
    }


   /* @Override
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
    }*/

    

    
    

    


}
