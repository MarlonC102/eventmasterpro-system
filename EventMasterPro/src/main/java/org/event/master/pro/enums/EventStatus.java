package org.event.master.pro.enums;

public enum EventStatus {
    CREATED("Created"),
    PUBLISHED("Published"),
    IN_PROGRESS("In Progress"),
    RESCHEDULED("Rescheduled"),
    FINISHED("Finished"),
    CANCELLED("Cancelled");

    private final String status;

    EventStatus(String status) {
        this.status = status;
    }

    public String getEventStatus() {
        return status;
    }
}
