package org.event.master.pro.enums;

public enum TicketStatus {
    AVAILABLE("Available"),
    SOLD("Sold"),
    USED("Used"),
    CANCELLED("Cancelled");

    private final String status;

    TicketStatus(String status) {
        this.status = status;
    }

    public String getEventStatus() {
        return status;
    }
}
