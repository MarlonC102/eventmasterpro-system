package org.event.master.pro.person.admin;

import org.event.master.pro.person.account.Account;

public class Admin extends Account{

    public Admin(String documentType, String documenNumbert, String name, String mail, String phone, String password, String rol) {
        super(documentType, documenNumbert, name, mail, phone, password, rol);
    }

    public void createEventFinance(){}
    public void viewSummaryFinance(){}
    public void setBudget(){}
    public void addRevenue(){}
    public void addExpenses(){}
}
