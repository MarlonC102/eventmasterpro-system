package org.event.master.pro.event.Concert;

import org.event.master.pro.event.Event.Event;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import org.event.master.pro.event.location.Location;
import org.event.master.pro.event.ticket.Ticket;
import org.event.master.pro.person.artist.Artist;
import org.event.master.pro.util.Database;

import static org.event.master.pro.util.Util.*;
import org.event.master.pro.util.sql.Select;

public class Concert extends Event {

    private Artist artist;
    private List<Artist> invitedArtist;
    private String genre;
    //private List<Ticket> ticket;
    //private int ticket;

    public Concert() {
    }

    public Concert(String name, String description, LocalDateTime dateTimeEvent, Location location, int duration, String sponsor, String classification, int participantsNumbers, Artist artist, List<Artist> invitedArtist, String type) {
        super(name, description, dateTimeEvent, location, duration, sponsor, classification, participantsNumbers, type);
        this.artist = artist;
        this.invitedArtist = invitedArtist;
        this.genre = genre;
        //this.ticket = ticket;

    }

    public Concert(String name, String description, LocalDateTime date, String type, Location location, List<Artist> invitedArtist) {
        super(name, description, date, type, location);
        this.invitedArtist = invitedArtist;
    }

    public Concert(String name, String description, LocalDateTime date, int duration, String sponsor, String classification, List<Artist> invitedArtist, int idEvent) {
        super(name, description, date, duration, sponsor, classification, idEvent);
        this.invitedArtist = invitedArtist;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Artist> getInvitedArtist() {
        return invitedArtist;
    }

    public void setInvitedArtist(List<Artist> invitedArtist) {
        this.invitedArtist = invitedArtist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
