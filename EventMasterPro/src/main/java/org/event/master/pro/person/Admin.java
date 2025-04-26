package org.event.master.pro.person;

public class Admin extends Person{
    public Admin(String documentType, String documenNumbert, String name, String mail, String phone, boolean status) {
        super(documentType, documenNumbert, name, mail, phone);
    }

    public void createEventFinance(){}
    public void viewSummaryFinance(){}
    public void setBudget(){}
    public void addRevenue(){}
    public void addExpenses(){}
}
