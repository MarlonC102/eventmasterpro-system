package org.event.master.pro.event.festival;

import org.event.master.pro.event.Event.Event;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.event.master.pro.event.location.Location;
import org.event.master.pro.event.ticket.Ticket;

import static org.event.master.pro.util.Util.*;

public class Festival extends Event {

    private Set<String> stage = new HashSet<>();
    int numberOfStage;
    private int day;
    private List<Ticket> ticket;

    public Festival() {

    }

    /*public Festival(Set<String> stage, int numberOfStage, int day, String name, String description, LocalDateTime dateTimeEvent, String statusEvent, Location location, int duration, String sponsor, String classification, int participantsNumbers, List<Ticket> ticket) {
        super(name, description, dateTimeEvent, statusEvent, location, duration, sponsor, classification, participantsNumbers);
        this.stage = stage;
        this.day = day;
        this.numberOfStage = numberOfStage;
        this.ticket = ticket;
    }
     */
    public Set<String> getStage() {
        return stage;
    }

    public void setStage(Set<String> stage) {
        this.stage = stage;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getNumberOfStage() {
        return numberOfStage;
    }

    public void setNumberOfStage(int numberOfStage) {
        this.numberOfStage = numberOfStage;
    }
}
