package org.event.master.pro.finance;

import org.event.master.pro.event.Event.Event;

import java.util.List;

public class Finance {
    private int id;
    private int eventId;
    private List<Revenue> listRevenues;
    private List<Expense> listExpense;

    public Finance() {
    }

    public Finance(List<Revenue> listRevenues, List<Expense> listExpense) {
        this.listRevenues = listRevenues;
        this.listExpense = listExpense;
    }

    public Finance(int eventId) {
        this.eventId = eventId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public List<Revenue> getListRevenues() {
        return listRevenues;
    }

    public void setListRevenues(List<Revenue> listRevenues) {
        this.listRevenues = listRevenues;
    }

    public List<Expense> getListExpense() {
        return listExpense;
    }

    public void setListExpense(List<Expense> listExpense) {
        this.listExpense = listExpense;
    }
    
    
    
    
    public void recordIncome(){}
    public void recordExpense(){}
    public void calculateBalance(){}
    public void showSummary(){}
    public void seeRevenueDetail(){}
    public void seeExpenseDetail(){}
}
