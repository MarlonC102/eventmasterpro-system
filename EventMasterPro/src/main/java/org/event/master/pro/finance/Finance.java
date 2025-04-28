package org.event.master.pro.finance;

import org.event.master.pro.event.Event;

import java.util.ArrayList;
import java.util.List;

import static org.event.master.pro.util.Util.printMessage;

public class Finance {
    private int id;
    private Event event;
    private double budgetTotal;
    private double incomeTotal;
    private double expensesTotal;
    private double balance;
    private List<Revenue> listRevenues;
    private List<Expense> listExpense;

    public Finance(int id, Event event, double budgetTotal, double incomeTotal, double expensesTotal, double balance) {
        this.id = id;
        this.event = event;
        this.budgetTotal = budgetTotal;
        this.incomeTotal = incomeTotal;
        this.expensesTotal = expensesTotal;
        this.balance = balance;
        listRevenues = new ArrayList<>();
        listExpense = new ArrayList<>();
    }

    public void recordIncome(Revenue revenue) {
        listRevenues.add(revenue);
    }

    public void recordExpense(Expense expense) {
        listExpense.add(expense);
    }

    public void calculateBalance(List<Revenue> revenues, List<Expense> expenses) {
        double sumRevenue = 0, sumExpenses = 0;
        for (Revenue revenue : revenues) {
            sumRevenue += revenue.getAmount();
        }
        for (Expense expense : expenses) {
            sumExpenses += expense.getAmount();
        }
        this.balance = sumExpenses - sumRevenue;
    }

    public void showSummary() {

        printMessage("Id: " + id);
        printMessage("Event: " + event);
        printMessage("The budget is: " + budgetTotal);
        printMessage("The Income is: " + incomeTotal);
        printMessage("Your balance is: " + balance);
    }

    public void seeRevenueDetail(List<Revenue> revenues) {
        printMessage ("The total revenue from the event are: " + revenues);
    }

    public void seeExpenseDetail(List<Expense> expenses) {
        printMessage ("The total expense from the event are: " +expenses);
    }
}
