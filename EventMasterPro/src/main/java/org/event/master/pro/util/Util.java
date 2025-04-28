package org.event.master.pro.util;

import java.util.Date;
import java.sql.Time;
import java.util.Scanner;

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


}
