package org.event.master.pro.event.ticket;

import org.event.master.pro.event.Event.Event;
import org.event.master.pro.enums.TicketStatus;
import org.event.master.pro.person.customer.Customer;

import java.util.ArrayList;
import java.util.List;

import static org.event.master.pro.util.Util.intInput;
import static org.event.master.pro.util.Util.printMessage;

public class Ticket {
    private int idTicket;
    private double price;
    private TicketStatus status;
    private String event;
    private Customer buyer;
    private int seatNumber;
    private String zone;
    private static int maxTickets;
    private static int id;
    private String description;
    private List<Ticket>tikets;

    public Ticket() {
        //this.status = TicketStatus.AVAILABLE.getEventStatus();
    }

    public Ticket(double price, TicketStatus tatus, String event, int seatNumber, String zone) {
        this.price = price;
        this.status = status;
        this.event = event;
        this.seatNumber = seatNumber;
        this.zone = zone;
    }
    
    public Ticket(double price, int seatNumber, String zone, String description){
        this.price = price;
        this.seatNumber = seatNumber;
        this.zone = zone;
        this.description = description;
        
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }
    
    

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
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

    public List<Ticket> getTikets() {
        return tikets;
    }

    public void setTikets(List<Ticket> tikets) {
        this.tikets = tikets;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

    public List<Ticket> createEntry(Event event, String zone, int count,double price) {
        List<Ticket> tickets = new ArrayList<>();
        Ticket ticket;
        for (int i = 0; i < count; i++) {
            ticket = new Ticket(price,TicketStatus.AVAILABLE,event.getName(),(i+1),zone);
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
       
    }


    public void queryTicket() {
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
