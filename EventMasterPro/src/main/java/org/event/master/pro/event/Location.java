package org.event.master.pro.event;

import java.util.List;

import static org.event.master.pro.util.Util.*;

public class Location {
    private int idLocation;
    private String name;
    private String address;
    private int capacity;
    private boolean available;
    private double price;
    private String city;
    private static int id = 0;


    public Location() {
        this.idLocation = id++;
    }

    public Location(String name, String address, int capacity, boolean available, double price, String city) {
        this.idLocation = id++;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.available = available;
        this.price = price;
        this.city = city;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static Location createLocation() {
        Location location = new Location();
        printMessage("\n--- Create Location ---");
        location.setName(strigsInput("Enter the name of the location: "));
        location.setCity(strigsInput("Enter the name of the city: "));
        location.setAddress(strigsInput("Enter the address of the location: "));
        location.setCapacity(intInput("Enter the capacity of the place (Number of people): "));
        location.setAvailable(true);
        location.setPrice(intInput("Enter the price of the site: "));
        return location;
    }

    public static void consultLocation(List<Location> locations) {
        if (locations != null && !locations.isEmpty()) {
            printMessage("----- List of Concerts -----");
            for (Location location : locations) {
                printMessage((location.getName()));
            }
        } else {
            printMessage("No locations to show.");
        }
    }

    public static Location consultSpecificLocation(String data, List<Location> locations) {
        if (locations != null) {
            for (Location location : locations) {
                if (location.getName().toLowerCase().equals(data.toLowerCase())) {
                    return location;
                }
            }
        } else {
            return null;
        }
        return null;
    }

    public Location updateLocation(String data, List<Location> locations) {
        if (locations.isEmpty()) {
            printMessage("No locations to show.");
        } else {
            for (Location updateLocation : locations) {
                if (updateLocation.getName().toLowerCase().equalsIgnoreCase(data)) {
                    updateLocation.setName(strigsInput("Enter the new name of the location\n"));
                    updateLocation.setCity(strigsInput("Enter the new name of the city\n"));
                    updateLocation.setAddress(strigsInput("Enter the new address of the location\n"));
                    updateLocation.setCapacity(intInput("Enter the new capacity of the place (Number of people)\n"));
                    updateLocation.setPrice(doubleInput("Enter the new price of the site\n"));
                }
                return updateLocation;
            }
        }
        return null;
    }

    public void seeAvailability(String data, List<Location> locations) {
        if (locations.isEmpty()) {
        } else {
            for (Location viewAvailability : locations) {
                if (viewAvailability.getName().toLowerCase().equals(data)) {
                    String status = viewAvailability.isAvailable() ? "Available" : "Not Available";
                    printMessage(status);
                }
            }
        }
    }

    //Por ahora no se usará este método, se reemplazará por changeAvailable, ya que harían lo mismo
    public void assignEvent() {
    }


    public Location changeAvailable(String data, List<Location> locations) {
        if (locations.isEmpty()) {
            printMessage("No locations to show.");
        } else {
            for (Location updateLocation : locations) {
                if (updateLocation.getName().toLowerCase().equalsIgnoreCase(data)) {
                    printMessage("Enter site availability (true or false)");
                    updateLocation.setAvailable(Boolean.parseBoolean(teclado.nextLine()));
                }
                return updateLocation;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return idLocation + ". " +
                name +
                "\nCity: " + city +
                "\nAddress: " + address +
                "\nCapacity: " + capacity +
                "\nAvailability: " + available +
                "\nPrice=" + price;
    }
}
