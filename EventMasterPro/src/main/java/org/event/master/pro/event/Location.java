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

    public Location(){}
    public Location(String name, String address, int capacity, boolean available, double price, String city) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.available = available;
        this.price = price;
        this.city = city;
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

    public static Location createLocation(){
        Location location = new Location();
        printMessage("Ingrese el nombre del lugar");
        location.setName(teclado.nextLine());
        printMessage("Ingrese el nombre de la ciudad");
        location.setCity(teclado.nextLine());
        printMessage("Ingrese la dirección del lugar");
        location.setAddress(teclado.nextLine());
        printMessage("Ingrese la capacidad del lugar (Cantidad de personas)");
        location.setCapacity(teclado.nextInt());
        location.setAvailable(true);
        printMessage("Ingrese el precio del lugar");
        location.setPrice(teclado.nextDouble());
        return location;
    }
    public static void consultLocation(List<Location> locations){
        if (locations.isEmpty()) {
            System.out.println("No locations to show.");
        } else {
            for (Location location : locations) {
                System.out.println(location);
            }
        }
    }

    public void consultSpecificLocation(){}
    public void seeAvailability(){};
    public void assignEvent(){};
    public void updateEvent(){};
    public void changeAvailable(){};
    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", capacity=" + capacity +
                ", available=" + available +
                ", price=" + price +
                ", city='" + city + '\'' +
                '}';
    }
}
