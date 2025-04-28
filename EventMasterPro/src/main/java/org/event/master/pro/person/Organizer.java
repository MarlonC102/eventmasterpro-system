package org.event.master.pro.person;

import org.event.master.pro.event.*;
import java.util.List;

import static org.event.master.pro.util.Util.*;

public class Organizer extends Account{
    private boolean status;

    public Organizer(String documentType, String documenNumbert, String name, String mail, String phone, String password, String rol) {
        super(documentType, documenNumbert, name, mail, phone, password, rol);
        this.status = true;
    }

    @Override
    public boolean isStatus() {
        return status;
    }
    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }
    public Event createEvent(List<Location> loc){
        printMessage("Create New Event");
        int typeOption = intInput("""
                Select event type: 
                1.Festival
                2.Concert
                3.Conference""");
        switch (typeOption){
            case 1:
                Festival festival = new Festival();
                festival.createEvent(loc);
                return festival;
            case 2:
                Concert concert = new Concert();
                concert.createEvent(loc);
                return concert;
            case 3:
                Conference conference = new Conference();
                conference.createEvent(loc);
                return conference;
            default:
                printMessage("Invalid event type selected.");
                return null;
        }
    }
    public Event editEvent(List<Event> events,List<Location> locations){
        String nameToUpdate = strigsInput("Enter the name of the concert to update: ");
        for (Event event : events) {
            if (event.getName().equalsIgnoreCase(nameToUpdate)) {
                event.updateEvent(locations);
                return event;
            }
        }
        printMessage("Festival not found");
        return null;
    }
    public Event cancelEvent(List<Event> events){
        String nameToUpdate = strigsInput("Enter the name of the concert to update: ");
        for (Event event : events) {
            if (event.getName().equalsIgnoreCase(nameToUpdate)) {
                event.changeStatusEvent(event);
                return event;
            }
        }
        printMessage("Festival not found");
        return null;
    }
    public void consultFinances(){}
    public void seeTicketsAvailability(){}
    public void viewEventSummary(Event event){
        printMessage(String.format("""
                ----- Event -----
                Event Name: %s
                Date: %s
                Location: %s
                Description: %s
                """,event.getName(),event.getDateEvent(),event.getLocation(),event.getDescription()));
    }
    public void listEvent(List<Event> events){
        printMessage("----- List of events -----");
        for(Event event :events){
            event.consultEvent(event);
        }
    }
}
