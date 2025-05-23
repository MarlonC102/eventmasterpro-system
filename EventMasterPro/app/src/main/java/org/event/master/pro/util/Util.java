package org.event.master.pro.util;

import java.awt.Color;
import java.awt.Font;
import org.event.master.pro.event.Event.Event;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.JTextComponent;

public class Util {
    public static final Scanner teclado = new Scanner(System.in);

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static String strigsInput(String message) {
        printMessage(message);
        return teclado.nextLine();
    }

    public static int intInput(String message) {
        printMessage(message);
        return Integer.parseInt(teclado.nextLine());
    }

    public static boolean booleanInput(String message) {
        printMessage(message);
        return Boolean.parseBoolean(teclado.nextLine());
    }

    public static Double doubleInput(String message) {
        printMessage(message);
        return Double.parseDouble(teclado.nextLine());
    }

    public static Time inputTime(String message) {
        printMessage(message);
        return java.sql.Time.valueOf(teclado.nextLine() + ":00");
    }

    public static Date inputDate(String message) {
        printMessage(message);
        try {
            return new java.text.SimpleDateFormat("yyyy-MM-dd").parse(teclado.nextLine());
        } catch (Exception e) {
            printMessage(message);
            return new java.util.Date();
        }
    }
    
    
    

    public static Event searchEvent(List<Event> events){
        String nameToUpdate = strigsInput("Enter the name of the event you wish to search for:");
        for (Event event : events) {
            if (event.getName().equalsIgnoreCase(nameToUpdate)) {
                return event;
            }
        }
        printMessage("Event not found");
        return null;
    }
    
    public static String formatNumbers(Double price){
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');

        DecimalFormat formatter = new DecimalFormat("#,###.##", symbols);
        return formatter.format(price);
    }

}
