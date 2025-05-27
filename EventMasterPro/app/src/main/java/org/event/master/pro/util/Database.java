package org.event.master.pro.util;

import org.h2.tools.RunScript;
import org.h2.tools.Server;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.event.master.pro.util.Util.printMessage;

public class Database {

    public static void upDatabase() {
        try {
            Files.deleteIfExists(Paths.get("./.db/event_master_pro.mv.db"));
            Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8085").start();
            printMessage("H2 console started at http://localhost:8085");
            try (Connection connection = getConnection()) {
                InputStream input = Database.class.getClassLoader().getResourceAsStream("sql/init_schema.sql");

                if (input != null) {
                    RunScript.execute(connection, new InputStreamReader(input));
                } else {
                    printMessage("Could not find init_schema.sql in /resources/sql.");
                }
                InputStream dataStream = Database.class.getClassLoader().getResourceAsStream("sql/full_test_data.sql");
                if (dataStream != null) {
                    RunScript.execute(connection, new InputStreamReader(dataStream));
                    printMessage("Database script successfully executed.");
                } else {
                    printMessage("Could not find full_test_data.sql in /resources/sql.");
                }
            }

        } catch (Exception e) {
            printMessage("Error starting the database.");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:h2:file:./.db/event_master_pro_db;AUTO_SERVER=TRUE";
        String user = "event_master_pro";
        String password = "admin";
        return DriverManager.getConnection(url, user, password);
    }

    public static Connection connection() throws SQLException {
        Connection conn = Database.getConnection();
        return conn;
    }
}
