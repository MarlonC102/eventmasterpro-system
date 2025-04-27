package org.event.master.pro.event;

import org.event.master.pro.enums.TicketStatus;

import java.util.List;

import static org.event.master.pro.util.Util.intInput;
import static org.event.master.pro.util.Util.printMessage;

public class Ticket {
    private int idTicket;
    private String eventType;
    private double price;
    private String status;
    private Event event;
    private Customer buyer;
    private int seatNumber;
    private String zone;
    private static int maxTickets;
    private static int id = 1;

    public Ticket() {
        this.idTicket = id++;
        this.status = TicketStatus.AVAILABLE.getEventStatus();
    }

    public Ticket(String eventType, double price, String status, Event event, Customer buyer, int seatNumber, String zone) {
        this.idTicket = id++;
        this.eventType = eventType;
        this.price = price;
        this.status = status;
        this.event = event;
        this.buyer = buyer;
        this.seatNumber = seatNumber;
        this.zone = zone;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Customer getBuyer() {
        return buyer;
    }

    public void setBuyer(Customer buyer) {
        this.buyer = buyer;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public static int getMaxTickets() {
        return maxTickets;
    }

    public static void setMaxTickets(int participants) {
        maxTickets = participants;
    }

    public Ticket createEntry(Customer customer, Event event, String zone, int seatNumber) {
        if (event.getCurrentParticipants() < event.getParticipantsNumbers()) {
            Ticket ticket = new Ticket();
            ticket.setBuyer(customer);
            ticket.setEvent(event);
            ticket.setZone(zone);
            ticket.setSeatNumber(seatNumber);
            ticket.setStatus(TicketStatus.SOLD.getEventStatus());
            event.incrementCurrentParticipants();
            event.getTicketsSold().add(ticket);
            System.out.println("Ticket purchased for " + customer.getName());
            return ticket;
        } else {
            System.out.println("No more tickets available for this event.");
        }
        return null;

    }

    public static Ticket findTicketById(List<Ticket> ticketsSold, int id) {
        for (Ticket ticket : ticketsSold) {
            if (ticket.getIdTicket() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void changeStatus() {
        do {
            printMessage("-------------Select an option-------------\n" +
                    "1. Book ticket\n" +
                    "2. Pay ticket\n" +
                    "3. Request refund\n" +
                    "4. Cancel ticket\n" +
                    "5. Exit\n" +
                    "--------------------------------------------");

            int op = intInput("Select an option");

            switch (op) {
                case 1:
                    if (status.equals(TicketStatus.AVAILABLE.getEventStatus())) {
                        status = TicketStatus.RESERVED.getEventStatus();
                        printMessage("Ticket reserved successfully.");
                    } else {
                        printMessage("You cannot reserve this ticket.");
                    }
                    break;
                case 2:
                    if (status.equals(TicketStatus.RESERVED.getEventStatus())) {
                        status = TicketStatus.SOLD.getEventStatus();
                        printMessage("Ticket paid successfully.");
                    } else {
                        printMessage("You can only pay reserved tickets.");
                    }
                    break;
                case 3:
                    if (status.equals(TicketStatus.SOLD.getEventStatus()) || status.equals(TicketStatus.USED.getEventStatus()) || status.equals(TicketStatus.CANCELLED.getEventStatus())) {
                        status = TicketStatus.REFUNDED.getEventStatus();
                        printMessage("Ticket refunded successfully.");
                    } else {
                        printMessage("This ticket cannot be refunded.");
                    }
                    break;
                case 4:
                    if (status.equals(TicketStatus.RESERVED.getEventStatus())) {
                        status = TicketStatus.CANCELLED.getEventStatus();
                        printMessage("Ticket cancelled successfully.");
                    } else {
                        printMessage("You can only cancel reserved tickets.");
                    }
                    break;
                case 5:
                    return; // Salir del método
                default:
                    printMessage("Wrong option.");
            }
        } while (true);
    }


    public void queryEntry() {
    }


    public void availability() {
    }


}
