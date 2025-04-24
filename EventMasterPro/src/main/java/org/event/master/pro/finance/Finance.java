package org.event.master.pro.finance;

import org.event.master.pro.event.Event;

import java.util.List;

public class Finance {
    private int id;
    private Event event;
    private double budgetTotal;
    private double incomeTotal;
    private double expensesTotal;
    private double balance;
    private List<Revenue> listRevenues;
    private List<Expense> listExpense;

    public void recordIncome(){}
    public void recordExpense(){}
    public void calculateBalance(){}
    public void showSummary(){}
    public void seeRevenueDetail(){}
    public void seeExpenseDetail(){}
}
