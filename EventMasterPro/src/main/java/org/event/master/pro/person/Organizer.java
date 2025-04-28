package org.event.master.pro.person;

import org.event.master.pro.event.*;
import org.event.master.pro.util.Data;

import java.util.List;

import static org.event.master.pro.util.Data.events;
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
    public void createEvent(List<Location> loc){
        printMessage("Create New Event");
        int typeOption = intInput("""
                Select event type: 
                1.Festival
                2.Concert
                3.Conference""");
        switch (typeOption){
            case 1:
                Festival festival = new Festival();
                events.add(festival.createEvent(loc));
                break;
            case 2:
                Concert concert = new Concert();
                events.add(concert.createEvent(loc));
                break;
            case 3:
                Conference conference = new Conference();
                events.add(conference.createEvent(loc));
                break;
            default:
                printMessage("Invalid event type selected.");
                break;
        }
    }
    public void editEvent(List<Event> events,List<Location> locations){
        boolean eventFound = false;
        String nameToUpdate = strigsInput("Enter the name of the event to update: ");
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getName().equalsIgnoreCase(nameToUpdate)) {
                Data.events.set(i,events.get(i).updateEvent(locations));
                eventFound=true;
                break;
            }
        }
        if (!eventFound) {
            printMessage("Event not found");
        }
    }
    public void cancelEvent(List<Event> events){
        boolean eventFound = false;
        String nameToUpdate = strigsInput("Enter the name of the event to update: ");
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getName().equalsIgnoreCase(nameToUpdate)) {
                Data.events.set(i,events.get(i).changeStatusEvent(events.get(i)));
            }
        }
        if (!eventFound) {
            printMessage("Event not found");
        }
    }
    public void consultFinances(){}
    public void seeTicketsAvailability(){}
    public void viewEventSummary(List<Event> events){
        String nameToUpdate = strigsInput("Enter the name of the event you wish to search for:");
        for (Event event : events) {
            if (event.getName().equalsIgnoreCase(nameToUpdate)) {
                printMessage(String.format("""
                        ----- Event -----
                        Event Name: %s
                        Description: %s
                        Date: %s
                        Location: %s
                        Participants: %s
                        Status: %s
                        """, event.getName(), event.getDescription(), event.getDateEvent(), event.getLocation(), event.getParticipantsNumbers(), event.getStatusEvent()));
            }
        }
        printMessage("Event not found");
    }
    public void listEvent(List<Event> events){
        printMessage("----- List of events -----");
        for(Event event :events){
            event.consultEvent(event);
        }
    }
}
