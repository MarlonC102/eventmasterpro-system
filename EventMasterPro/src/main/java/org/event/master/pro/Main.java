package org.event.master.pro;

import org.event.master.pro.event.Location;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Location location = new Location();
        List<Location> locations = new ArrayList<>();
        locations.add(location.createLocation());

        //location.consultLocation();
    }
}