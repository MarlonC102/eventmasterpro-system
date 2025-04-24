package org.event.master.pro.event;

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

    public String setName(String name) {
        this.name = name;
        return this.name;
    }

    public String getAddress() {
        return address;
    }

    public String setAddress(String address) {
        this.address = address;
        return this.address;
    }

    public int getCapacity() {
        return capacity;
    }

    public int setCapacity(int capacity) {
        this.capacity = capacity;
        return this.capacity;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean setAvailable(boolean available) {
        this.available = available;
        return this.available;
    }

    public double getPrice() {
        return price;
    }

    public double setPrice(double price) {
        this.price = price;
        return this.price;
    }

    public String getCity() {
        return city;
    }

    public String setCity(String city) {
        this.city = city;
        return this.city;
    }

    public Location createLocation(){
        printMessage("Ingrese el nombre del lugar");
        name = setName(teclado.nextLine());
        printMessage("Ingrese el nombre de la ciudad");
        city = setCity(teclado.nextLine());
        printMessage("Ingrese la dirección del lugar");
        address = setAddress(teclado.nextLine());
        printMessage("Ingrese la capacidad del lugar (Cantidad de personas)");
        capacity = setCapacity(teclado.nextInt());
        available = setAvailable(true);
        printMessage("Ingrese el precio del lugar");
        price = setPrice(teclado.nextDouble());
        return new Location(name,address,capacity,available,price, city);
    };
    public void consultLocation(){};
    public void consultSpecificLocation(){}
    public void seeAvailability(){};
    public void assignEvent(){};
    public void updateEvent(){};
    public void changeAvailable(){};
}
