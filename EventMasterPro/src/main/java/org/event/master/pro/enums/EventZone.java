package org.event.master.pro.enums;

public enum EventZone {
    VIPN("VIP"),
    VIP("Exclusive area near the stage, with extra services."),
    PREFERENTIALN("Preferential"),
    PREFERENTIAL("Good locations, behind or beside the VIP."),
    GENERALN("General"),
    GENERAL("Common area with standard access, further from the stage.");

    private final String description;

    EventZone(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
