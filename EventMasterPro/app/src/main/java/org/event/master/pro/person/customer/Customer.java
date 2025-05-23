package org.event.master.pro.person.customer;

import org.event.master.pro.event.Concert.Concert;
import org.event.master.pro.event.Event.Event;
import org.event.master.pro.event.ticket.Ticket;

import java.util.ArrayList;
import java.util.List;
import org.event.master.pro.person.account.Account;

import static org.event.master.pro.util.Util.*;

public class Customer extends Account {
    private int age;
    private List<String> history;
    private List<Ticket> tickets;


    public Customer(String documentType, String documenNumbert, String name, String mail, String phone, String password, String rol, int age) {
        super(documentType, documenNumbert, name, mail, phone, password, rol);
        this.age = age;
        history = new ArrayList<String>();
    }

    /*public void buyTicket(List<Event> events, String customer) {
        viewEventSummary(events);

        Concert concert = new Concert();
        Event eventToBuy = concert.consultSpecificEvent(events);

        if (eventToBuy == null) {
            printMessage("Event not found.");
            return;
        }

        if (!eventToBuy.getStatusEvent().equalsIgnoreCase("Published")) {
            printMessage("This event is not published yet.");
            return;
        }

        int ticketToBuy = intInput("Enter the number of tickets you want to buy");

        //List<Ticket> tickets = eventToBuy.getTickets();
        boolean ticketReserved = false;

        if (tickets != null && !tickets.isEmpty()) {
            for (Ticket ticket : tickets) {
                if (ticket.getStatus().equalsIgnoreCase("Available")) {
                    if (ticket.getSeatNumber() >= ticketToBuy) {

                        ticket.setSeatNumber(ticket.getSeatNumber() - ticketToBuy);

                        if (ticket.getSeatNumber() == 0) {
                            ticket.setStatus("Sold");
                        }


                        if (this.tickets == null) {
                            this.tickets = new ArrayList<>();
                        }
                        this.tickets.add(ticket);

                        ticketReserved = true;
                        break;
                    }
                }
            }
        }

        if (ticketReserved) {
            printMessage("Tickets successfully reserved for " + customer + "!");
        } else {
            printMessage("Not enough tickets available in the selected zone.");
        }
    }

*/
    public void listEvent(List<Event> events) {
        boolean published = false;
        if (events != null && !events.isEmpty()) {
            printMessage("----- List of Available Events -----");
            for (Event event : events) {
                if (event.getStatusEvent().equals("Published")) {
                    printMessage(String.format("""
                            Event: %s
                            Date: %s
                            Hour: %s""", event.getName()));
                    published = true;
                }
            }
        } else {
            printMessage("No events available to show.");
        }
        if (!published) {
            printMessage("No events published to show.");
        }
    }

    public void viewEventSummary(List<Event> events) {
        /*Event event = searchEvent(events);
        if (event != null) {
            if (event.getStatusEvent().equals("Published")) {
                printMessage(String.format("""
                        ----- Event -----
                        Event Name: %s
                        Description: %s
                        Date: %s
                        Location: %s
                        """, event.getName(), event.getDescription(), event.getDateEvent(), event.getLocation().customerInfo()));
            } else {
                printMessage("the event you are looking for has not been published");
            }

        }*/
    }

    public void seeTicketsAvailability(List<Event> events) {

    }
}
