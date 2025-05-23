package org.event.master.pro.enums;

public enum EventZone {
    VIP("VIP"),
    VIPD("Exclusive area near the stage, with extra services."),
    PREFERENTIALN("Preferential"),
    PREFERENTIALD("Good locations, behind or beside the VIP."),
    GENERAL("General"),
    GENERALD("Common area with standard access, further from the stage.");

    private final String description;

    EventZone(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
