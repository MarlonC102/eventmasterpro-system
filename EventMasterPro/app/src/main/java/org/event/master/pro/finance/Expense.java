package org.event.master.pro.finance;

import java.time.LocalDateTime;

public class Expense {
    private int id;
    private String description;
    private double amount;
    private LocalDateTime date;
    private String category;
    private int financeId;

    public Expense() {
    }

    public Expense(int id, String description, double amount, LocalDateTime date, String category, int financeId) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.financeId = financeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getFinanceId() {
        return financeId;
    }

    public void setFinanceId(int eventId) {
        this.financeId = eventId;
    }
    
    
    
    
}
