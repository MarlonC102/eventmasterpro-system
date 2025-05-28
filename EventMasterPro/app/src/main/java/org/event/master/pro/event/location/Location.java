package org.event.master.pro.event.location;

public class Location {

    private String name;
    private String address;
    private String type;
    private int capacity;
    private boolean available;
    private double price;
    private String city;
    private String department;
    private String consideration;
    private boolean availability;
    private int idLocation;
    private static String id;

    public Location() {
    }

    public Location(String name, int idLocation) {
        this.name = name;
        this.idLocation = idLocation;
    }

    public Location(String name, String address, int capacity, String city, String department, String type, double price, String consideration) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.available = available;
        this.price = price;
        this.city = city;
        this.department = department;
        this.consideration = consideration;
        this.type = type;
    }

    public Location(String name, String address, String city, String department, String type, int capacity, boolean availability, double price, String consideration) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.available = available;
        this.price = price;
        this.city = city;
        this.department = department;
        this.consideration = consideration;
        this.type = type;
        this.availability = availability;
    }

    public Location(String name, String address, String city, String department, String type, int capacity, boolean availability, double price, String consideration, int idLocation) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.price = price;
        this.city = city;
        this.department = department;
        this.consideration = consideration;
        this.type = type;
        this.availability = availability;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getConsideration() {
        return consideration;
    }

    public void setConsideration(String consideration) {
        this.consideration = consideration;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Location.id = id;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    @Override
    public String toString() {
        return name;
    }

}
