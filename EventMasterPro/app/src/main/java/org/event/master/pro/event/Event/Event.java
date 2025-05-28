package org.event.master.pro.event.Event;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.event.master.pro.event.location.Location;
import org.event.master.pro.event.ticket.Ticket;
import org.event.master.pro.person.artist.Artist;

public class Event {

    private int idEvent;
    private static String id;
    private String name;
    private String description;
    private LocalDateTime dateTimeEvent;
    private LocalDateTime dateTimeEndEvent;
    private String statusEvent;
    private String type;
    private Location location;
    private int duration;
    private String sponsor;
    private String classification;
    private int participantsNumbers;
    private int currentParticipants;
    private List<Ticket> tickets = new ArrayList<>();
    private Artist artist;
    private List<Artist> invitedArtist;
    private String genre;

    public Event() {
    }

    public Event(String name, String description, LocalDateTime dateTimeEvent, int duration, String sponsor, String classification, int idEvent) {
        this.name = name;
        this.description = description;
        this.dateTimeEvent = dateTimeEvent;
        this.duration = duration;
        this.sponsor = sponsor;
        this.classification = classification;
        this.idEvent = idEvent;

    }

    public Event(String name, String description, LocalDateTime dateTimeEvent, String type, Location location) {
        this.name = name;
        this.description = description;
        this.dateTimeEvent = dateTimeEvent;
        this.type = type;
        this.location = location;
    }

    public Event(int idEvent, String name, String description, LocalDateTime dateTimeEvent, String type, Location location, int participantsNumbers) {
        this.name = name;
        this.description = description;
        this.dateTimeEvent = dateTimeEvent;
        this.type = type;
        this.location = location;
        this.idEvent = idEvent;
        this.participantsNumbers = participantsNumbers;
    }

    public Event(String name, String description, LocalDateTime dateTimeEvent, Location location, int duration, String sponsor, String classification, int participantsNumbers, Artist artist, List<Artist> invitedArtist, String type, String status) {
        this.name = name;
        this.artist = artist;
        this.description = description;
        this.dateTimeEvent = dateTimeEvent;
        this.location = location;
        this.duration = duration;
        this.sponsor = sponsor;
        this.classification = classification;
        this.participantsNumbers = participantsNumbers;
        this.type = type;
        this.dateTimeEndEvent = this.dateTimeEvent.plusHours(this.duration);
        this.invitedArtist = invitedArtist;
        this.statusEvent = status;

    }

    public Event(String name, String description, LocalDateTime dateTimeEvent, Location location, int duration, String sponsor, String classification, int participantsNumbers, Artist artist, List<Artist> invitedArtist, String type) {
        this.name = name;
        this.artist = artist;
        this.description = description;
        this.dateTimeEvent = dateTimeEvent;
        this.location = location;
        this.duration = duration;
        this.sponsor = sponsor;
        this.classification = classification;
        this.participantsNumbers = participantsNumbers;
        this.type = type;
        this.dateTimeEndEvent = this.dateTimeEvent.plusHours(this.duration);
        this.invitedArtist = invitedArtist;

    }

    public Event(String name, String description, LocalDateTime date, String type, Location location, List<Artist> invitedArtist) {
        this.name = name;
        this.description = description;
        this.dateTimeEvent = date;
        this.location = location;
        this.type = type;
        this.dateTimeEndEvent = this.dateTimeEvent.plusHours(this.duration);
        this.invitedArtist = invitedArtist;
    }

    public Event(String name, String description, LocalDateTime date, int duration, String sponsor, String classification, List<Artist> invitedArtist, int idEvent) {
        this.name = name;
        this.description = description;
        this.dateTimeEvent = date;
        this.duration = duration;
        this.sponsor = sponsor;
        this.classification = classification;
        this.dateTimeEndEvent = this.dateTimeEvent.plusHours(this.duration);
        this.invitedArtist = invitedArtist;
    }

    public Event(int idEvent, String name, String description,
            LocalDateTime dateTimeEvent, LocalDateTime dateTimeEndEvent,
            String statusEvent, String type, String classification, int quorum,
            String sponsor, Location location, Artist artist,
            List<Artist> invitedArtist, String genre, List<Ticket> tickets) {
        this.idEvent = idEvent;
        this.name = name;
        this.description = description;
        this.dateTimeEvent = dateTimeEvent;
        this.dateTimeEndEvent = dateTimeEndEvent;
        this.statusEvent = statusEvent;
        this.type = type;
        this.classification = classification;
        this.participantsNumbers = quorum;
        this.sponsor = sponsor;
        this.location = location;
        this.artist = artist;
        this.invitedArtist = invitedArtist;
        this.genre = genre;
        this.tickets = tickets;
    }

    public Event(String name, String descriptionEvent, LocalDateTime dateTime, int duration, String sponsorEvent, String classificationEvent, List<Artist> invited) {
        this.name = name;
        this.description = descriptionEvent;
        this.dateTimeEvent = dateTime;
        this.duration = duration;
        this.sponsor = sponsorEvent;
        this.classification = classificationEvent;
        this.invitedArtist = invited;

    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Event.id = id;
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

    public LocalDateTime getDateTimeEndEvent() {
        return dateTimeEndEvent;
    }

    public void setDateTimeEndEvent(LocalDateTime dateTimeEndEvent) {
        this.dateTimeEndEvent = dateTimeEndEvent;
    }

    public String getStatusEvent() {
        return statusEvent;
    }

    public void setStatusEvent(String statusEvent) {
        this.statusEvent = statusEvent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public void setParticipantsNumbers(int quorum) {
        this.participantsNumbers = quorum;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
