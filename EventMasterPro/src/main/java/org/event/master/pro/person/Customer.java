package org.event.master.pro.person;

public class Customer extends Person{
    private int age;
    private String history;

    public Customer(String documentType, String documenNumbert, String name, String mail, String phone, boolean status) {
        super(documentType, documenNumbert, name, mail, phone);
    }

    public void buyTicket(){}
    public void listEvent(){}
    public void viewEventSummary(){}
    public void seeTicketsAvailability(){}
}
