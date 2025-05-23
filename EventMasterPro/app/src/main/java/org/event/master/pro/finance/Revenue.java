package org.event.master.pro.finance;

import java.time.LocalDateTime;

public class Revenue {
    private int id;
    private String description;
    private double amount;
    private LocalDateTime date;
    private String source;
    private int financeId;
    
    public Revenue(){}
    
    public Revenue(String description, double amount, LocalDateTime date, String source, int financeId) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.source = source;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getFinanceId() {
        return financeId;
    }

    public void setFinanceId(int financeId) {
        this.financeId = financeId;
    }
    
    
}
