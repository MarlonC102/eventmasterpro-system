package org.event.master.pro;

import org.event.master.pro.event.Location;
<<<<<<< Updated upstream
import static org.event.master.pro.util.Util.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Location location = new Location();
        List<Location> locations = new ArrayList<>();


        locations.add(Location.createLocation());
        Location.consultLocation(locations);
=======
import org.event.master.pro.util.Database;

import java.sql.Connection;
import java.sql.SQLException;

import static org.event.master.pro.util.Menu.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Database.upDatabase();
        Connection conn = Database.getConnection();
        Location location = new Location();
        location.createLocation(conn);
        location.consultLocation(conn);
        location.consultSpecificLocation(conn);
        //homeMenu();
>>>>>>> Stashed changes
    }
}