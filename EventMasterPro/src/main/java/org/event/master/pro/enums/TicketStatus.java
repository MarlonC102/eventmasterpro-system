package org.event.master.pro.enums;

public enum TicketStatus {
    AVAILABLE("Available"),
    RESERVED("Reserved"),
    SOLD("Sold"),
    USED("Used"),
    CANCELLED("Cancelled"),
    REFUNDED("Refunded");

    private final String status;

    TicketStatus(String status) {
        this.status = status;
    }

    public String getEventStatus() {
        return status;
    }
}
