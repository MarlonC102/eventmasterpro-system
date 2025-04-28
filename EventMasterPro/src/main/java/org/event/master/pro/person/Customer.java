package org.event.master.pro.person;

import org.event.master.pro.event.Event;

import java.util.List;

import static org.event.master.pro.util.Util.printMessage;

public class Customer extends Account{
    private int age;
    private String history;

    public Customer(String documentType, String documenNumbert, String name, String mail, String phone, String password, String rol, int age, String history) {
        super(documentType, documenNumbert, name, mail, phone, password, rol);
        this.age = age;
        this.history = history;
    }

    public void buyTicket() {}
    public void listEvent(List<Event> events){
        if (events != null && !events.isEmpty()) {
            printMessage("----- List of Available Events -----");
            for (Event event : events) {
                printMessage(String.format("Event: %s | Date: %s",event.getName(),event.getDateEvent()));
            }
        } else {
            printMessage("No events available to show.");
        }
    }
    public void viewEventSummary(Event event){
        printMessage(String.format("""
                Event
                Event Name: %s
                Date: %s
                Location: %s
                Description: %s
                """,event.getName(),event.getDateEvent(),event.getLocation(),event.getDescription()));
    }
    public void seeTicketsAvailability(Event event){

    }
}
