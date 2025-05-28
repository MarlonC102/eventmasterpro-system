package org.event.master.pro.enums;

public enum EventStatus {
    Created("Created"),
    Published("Published"),
    Progress("Progress"),
    Finished("Finished"),
    Cancelled("Cancelled");

    private final String status;

    EventStatus(String status) {
        this.status = status;
    }

    public String getEventStatus() {
        return status;
    }
}
