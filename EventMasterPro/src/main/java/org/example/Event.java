package org.example;

import java.sql.Time;
import java.util.Date;

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

    public abstract void createEvent();
    public abstract void updateEvent();
    public abstract void changeStatusEvent();
    public abstract void consultEvent();
    public abstract void generateTicket();
}