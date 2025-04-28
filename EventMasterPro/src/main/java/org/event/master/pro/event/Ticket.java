package org.event.master.pro.event;

import org.event.master.pro.enums.TicketStatus;
import org.event.master.pro.person.Customer;

import java.util.ArrayList;
import java.util.List;

import static org.event.master.pro.util.Util.intInput;
import static org.event.master.pro.util.Util.printMessage;

public class Ticket {
    private int idTicket;
    private double price;
    private String status;
    private Event event;
    private Customer buyer;
    private int seatNumber;
    private String zone;
    private static int maxTickets;
    private static int id = 0;

    public Ticket() {
        this.status = TicketStatus.AVAILABLE.getEventStatus();
    }

    public Ticket(double price, String status, Event event, int seatNumber, String zone) {
        this.idTicket = id++;
        this.price = price;
        this.status = status;
        this.event = event;
        this.seatNumber = seatNumber;
        this.zone = zone;
    }

    public int getIdTicket() {
        return idTicket;
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

    public List<Ticket> createEntry(Event event, String zone, int count,double price) {
        List<Ticket> tickets = new ArrayList<>();
        Ticket ticket;
        for (int i = 0; i < count; i++) {
            ticket = new Ticket(price,TicketStatus.AVAILABLE.getEventStatus(),event,(i+1),zone);
            tickets.add(ticket);
        }
        return tickets;
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
            printMessage("""
                    -------------Select an option-------------
                    1. Book ticket
                    2. Pay ticket
                    3. Request refund
                    4. Cancel ticket
                    5. Exit
                    --------------------------------------------""");

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

    @Override
    public String toString() {
        return String.format("""
                Ticket
                Price: %s
                Seat number: %s
                Zone: %s""",price,seatNumber,zone);
    }
}
