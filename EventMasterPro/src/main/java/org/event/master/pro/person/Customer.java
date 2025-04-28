package org.event.master.pro.person;

import org.event.master.pro.event.Event;
import org.event.master.pro.event.Ticket;

import java.util.ArrayList;
import java.util.List;

import static org.event.master.pro.util.Util.printMessage;
import static org.event.master.pro.util.Util.searchEvent;

public class Customer extends Account{
    private int age;
    private List<String> history;
    private List<Ticket> tickets;

    public Customer(String documentType, String documenNumbert, String name, String mail, String phone, String password, String rol, int age) {
        super(documentType, documenNumbert, name, mail, phone, password, rol);
        this.age = age;
        history = new ArrayList<String>();
    }

    public void buyTicket(List<Event>events) {
        viewEventSummary(events);
    }
    public void listEvent(List<Event> events){
        boolean published = false;
        if (events != null && !events.isEmpty()) {
            printMessage("----- List of Available Events -----");
            for (Event event : events) {
                if (event.getStatusEvent().equals("Published")) {
                    printMessage(String.format("""
                            Event: %s
                            Date: %s""", event.getName(), event.getDateEvent()));
                    published = true;
                }
            }
        }else {
            printMessage("No events available to show.");
        }
        if (!published) {
            printMessage("No events published to show.");
        }
    }
    public void viewEventSummary(List<Event> events){
        Event event = searchEvent(events);
        if (event != null){
            if (event.getStatusEvent().equals("Published")) {
                printMessage(String.format("""
                        ----- Event -----
                        Event Name: %s
                        Description: %s
                        Date: %s
                        Location: %s
                        Tickets: %s
                        """, event.getName(), event.getDescription(), event.getDateEvent(), event.getLocation().customerInfo(),event.getTickets()));
            }else {
                printMessage("the event you are looking for has not been published");
            }

        }
    }
    public void seeTicketsAvailability(List<Event> events){

    }
}
