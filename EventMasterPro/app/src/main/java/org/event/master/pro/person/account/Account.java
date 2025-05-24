package org.event.master.pro.person.account;

import org.event.master.pro.person.person.Person;

import static org.event.master.pro.util.Util.printMessage;

public class Account extends Person {
    private String password;
    private static String rol;
    private static boolean isLoggedIn;
    private String name;
    static String id;

    public static String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Account() {
        super();
    }

    public Account(String documentType, String documenNumbert, String name, String mail, String phone, String password, String rol) {
        super(documentType, documenNumbert, name, mail, phone);
        this.password = password;
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static boolean isLoggedIn() {
        return isLoggedIn;
    }

    public static void setIsLoggedIn(boolean isLoggedIn) {
        Account.isLoggedIn = isLoggedIn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Account.id = id;
    }    

    public static void logout() {
        if (isLoggedIn) {
            isLoggedIn = false;
        }
    }

    /*public void resetPassword(String documenNumbert) {
        if (isStatus()) {
            if (documenNumbert.equals(getDocumenNumber())) {
                printMessage("New password:");
                this.password = teclado.nextLine();
            } else {
                printMessage("Incorrect document");
            }
        } else {
            printMessage("The account is inactive.");
        }
    }*/

    
}
