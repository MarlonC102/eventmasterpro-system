package org.event.master.pro.person;

public class Artist extends Person{
    private String artisticName;
    private String requeriments;
    private double price;
    private String genre;

    public Artist(String documentType, String documenNumbert, String name, String mail, String phone, boolean status) {
        super(documentType, documenNumbert, name, mail, phone);
    }

    public void getTechRequirements(){}

}
