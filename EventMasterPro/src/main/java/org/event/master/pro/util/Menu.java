package org.event.master.pro.util;

import org.event.master.pro.event.Event;
import org.event.master.pro.event.Location;
import org.event.master.pro.person.Account;

import java.util.List;
import java.util.function.Consumer;
import static org.event.master.pro.util.Data.*;
import static org.event.master.pro.util.Util.*;
import static org.event.master.pro.util.Util.printMessage;

public class Menu {
    private static int option = -1;
    public static void showMenu(String title, String optionsText, Consumer<Integer> action) {
        int selectedOption;
        do {
            selectedOption = intInput(String.format("%s%n%s",title,optionsText));
            action.accept(selectedOption);
        } while (selectedOption != 0);
    }
    public static void login(Account account) {
        showMenu(
            "------ Select an option ------",
            """
                1). Log in.
                2). Password recovery.
                0). Exit.
                Select an option: """,
            option -> {
                switch (option) {
                    case 1 -> {
                        String documenNumbert = strigsInput("Enter your document number: ");
                        String password = strigsInput("Enter your password: ");
                        account.login(password, documenNumbert);
                        if (account.getRol().equals("customer")){
                            customerMenu();
                        }else if(account.getRol().equals("organizer")){
                            organizerMenu();
                        }
                    }
                    case 2 -> {
                        String documenNumbert = strigsInput("Enter your document number: ");
                        account.resetPassword(documenNumbert);
                    }
                    case 0 -> printMessage("Leaving...");
                    default -> printMessage("Invalid option.");
                }
            }
        );
    }

    public static void homeMenu() {
        showMenu(
            "------ Welcome to the system ------",
            """
                Select Account to Login:
                1). Customer
                2). Organizer
                3). Administrator
                0). Exit
                Select an option: """,
            option -> {
                switch (option) {
                    case 1 -> login(customer);
                    case 2 -> login(organizer);
                    case 3 -> printMessage("this option is not available at the moment");
                    case 0 -> printMessage("Leaving...");
                    default -> printMessage("Invalid option.");
                }
            }
        );
    }
    public static void customerMenu() {
        if(customer.isLoggedIn()) {
            showMenu(
                    "------ Customer menu ------",
                    """
                            1). Buy ticket
                            2). List event
                            3). See Tickets Availability
                            4). View Event Summary
                            0). Log out
                            Select an option: """,
                    option -> {
                        switch (option) {
                            case 1 -> printMessage("this option is not available at the moment");
                            case 2 -> customer.listEvent(events);
                            case 3 -> printMessage("this option is not available at the moment");
                            case 4 -> customer.viewEventSummary(events);
                            case 0 -> {
                                customer.logout();
                                printMessage("Leaving...");
                            }
                            default -> printMessage("Invalid option.");
                        }
                    }
            );
        }
    }
    public static void organizerMenu() {
        if(organizer.isLoggedIn()) {
            showMenu(
                    "------ Organizer menu ------",
                    """
                            1). Create event
                            2). List event
                            3). Edit event
                            4). Change event status
                            5). Consult finances
                            6). See Tickets Availability
                            7). View Event Summary
                            0). Log out
                            Select an option: """,
                    option -> {
                        switch (option) {
                            case 1 -> organizer.createEvent(locations);
                            case 2 -> organizer.listEvent(events);
                            case 3 -> organizer.editEvent(events,locations);
                            case 4 -> organizer.cancelEvent(events);
                            case 5 -> printMessage("this option is not available at the moment");
                            case 6 -> printMessage("this option is not available at the moment");
                            case 7 -> organizer.viewEventSummary(events);
                            case 0 -> {
                                organizer.logout();
                                printMessage("Leaving...");
                            }
                            default -> printMessage("Invalid option.");
                        }
                    }
            );
        }
    }

}
