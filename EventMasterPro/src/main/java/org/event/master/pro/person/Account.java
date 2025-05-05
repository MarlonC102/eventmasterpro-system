package org.event.master.pro.person;

import static org.event.master.pro.util.Util.printMessage;
import static org.event.master.pro.util.Util.teclado;

public class Account extends Person{
    private String password;
    private String rol;
    private boolean isLoggedIn;

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Account(String documentType, String documenNumbert, String name, String mail, String phone, String password, String rol) {
        super(documentType, documenNumbert, name, mail, phone);
        this.password = password;
        this.rol = rol;
    }

    public void login( String password, String documenNumbert){
        if (isStatus()){
            if (documenNumbert.equals(getDocumenNumbert()) && password.equals(this.password)){
                printMessage(String.format("Successful login. Welcome, %s",getName()));
                isLoggedIn = true;
            }else{
                printMessage("Incorrect document or password.");
                isLoggedIn = false;
            }
        }else{
            printMessage("The account is inactive.");
            isLoggedIn=false;
        }
    }
    public void logout(){
        if (isLoggedIn){
            isLoggedIn = false;
            printMessage(String.format("Closed session for %s",getName()));
        }else {
            printMessage("There is no active session to close.");
        }
    }
    public void resetPassword(String documenNumbert){
        if (isStatus()){
            if (documenNumbert.equals(getDocumenNumbert())){
                printMessage("New password:");
                this.password = teclado.nextLine();
            }else{
                printMessage("Incorrect document");
            }
        }else{
            printMessage("The account is inactive.");
        }
    }
    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}
