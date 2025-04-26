package org.event.master.pro.person;

public class Organizer extends Person{
    private boolean status;

    public Organizer(String documentType, String documenNumbert, String name, String mail, String phone, boolean status) {
        super(documentType, documenNumbert, name, mail, phone);
    }

    public void createEvent(){}
    public void editEvent(){}
    public void cancelEvent(){}
    public void assignLocal(){}
    public void assignArtist(){}
    public void consultFinances(){}
    public void seeTicketsAvailability(){}
    public void viewEventSummary(){}
}
