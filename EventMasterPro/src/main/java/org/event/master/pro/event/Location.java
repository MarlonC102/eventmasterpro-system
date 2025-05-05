package org.event.master.pro.event;

import org.event.master.pro.util.sql.Insert;
import org.event.master.pro.util.sql.Select;
import org.event.master.pro.util.sql.Update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.event.master.pro.util.Util.*;

public class Location {
    private int idLocation;
    private String name;
    private String address;
    private String type;
    private int capacity;
    private boolean available;
    private double price;
    private String city;
    private static int id = 0;


    public Location() {
        this.idLocation = id++;
    }

    public Location(String name, String address, int capacity, boolean available, double price, String city, String type) {
        this.idLocation = id++;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.available = available;
        this.price = price;
        this.city = city;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void createLocation(Connection conn) {
        String sql = Insert.INSERT_LOCATION.getQuery();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            Location location = new Location();
            printMessage("\n--- Create Location ---");
            location.setName(strigsInput("Enter the name of the location: "));
            location.setCity(strigsInput("Enter the name of the city: "));
            location.setType(strigsInput("Enter the type of the location: "));
            location.setAddress(strigsInput("Enter the address of the location: "));
            location.setCapacity(intInput("Enter the capacity of the place (Number of people): "));
            location.setAvailable(true);
            location.setPrice(intInput("Enter the price of the site: "));
            stmt.setString(1, location.getName());
            stmt.setString(2, location.getAddress());
            stmt.setInt(3, location.getCapacity());
            stmt.setString(4, location.getCity());
            stmt.setString(5, location.getType());
            stmt.setBoolean(6, true);
            stmt.setDouble(7, location.getPrice());
            stmt.setInt(8, 1);
            stmt.executeUpdate();
            printMessage("Location created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Can't create event: " + e.getMessage());
        }

    }

    public static void consultLocation(Connection conn) {
        String sql = Select.SELECT_LOCATION.getQuery();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            printMessage("----- List of Concerts -----");
            while (rs.next()) {
                String name = rs.getString("name");
                printMessage(name);
            }
            if (!rs.next()) {
                printMessage("Locations not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Cant search locations");
        }
    }

    public static Location consultSpecificLocation(Connection conn) {
        Location location = new Location();
        String sql = Select.SELECT_LOCATION_BY_NAME.getQuery();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            location.setName(strigsInput("Enter the name of the location: "));
            stmt.setString(1, "%" + location.getName() + "%");
            ResultSet rs = stmt.executeQuery();
            printMessage("----- List of Locations -----");
            while (rs.next()) {
                location.setIdLocation(rs.getInt("id_location"));
                location.setName(rs.getString("name"));
                location.setAddress(rs.getString("address"));
                location.setCity(rs.getString("city"));
                location.setCapacity(rs.getInt("capacity"));
                location.setPrice(rs.getDouble("price_location"));
                printMessage(location.getName() + " " + location.getAddress() + " " + location.getPrice());
                return location;
            }
            if (!rs.next()) {
                printMessage("Error searching for location.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return location;
    }

    public void updateLocation(String data, List<Location> locations) {
        Location location = new Location();
        String sql = Update.UPDATE_LOCATION.getQuery();

        /*if (locations.isEmpty()) {
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
        return null;*/
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
<<<<<<< Updated upstream
                "\nPrice=" + price;
=======
                "\nPrice: " + price;
    }

    public String customerInfo() {
        return idLocation + ". " +
                name +
                "\nCity: " + city +
                "\nAddress: " + address;
>>>>>>> Stashed changes
    }
}
