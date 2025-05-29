package org.event.master.pro.person.customer;

import org.event.master.pro.event.ticket.Ticket;

import java.util.ArrayList;
import java.util.List;
import org.event.master.pro.person.account.Account;

public class Customer extends Account {
    private int age;
    private List<String> history;
    private List<Ticket> tickets;


    public Customer(){}
    
    public Customer(String documentType, String documenNumbert, String name, String mail, String phone, String password, String rol, int age) {
        super(documentType, documenNumbert, name, mail, phone, password, rol);
        this.age = age;
        history = new ArrayList<String>();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    
    

    
}
