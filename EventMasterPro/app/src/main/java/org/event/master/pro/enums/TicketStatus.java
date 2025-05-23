package org.event.master.pro.enums;

public enum TicketStatus {
    AVAILABLE("Available"),
    RESERVED("Reserved"),
    SOLD("Sold"),
    CANCELLED("Cancelled"),
    REFUNDED("Refunded"),
    ACTIVE("Active"),
    USED("Used"),
    RESCHEDULED("Rescheduled");

    private final String status;

    TicketStatus(String status) {
        this.status = status;
    }

    public String getEventStatus() {
        return status;
    }
}
