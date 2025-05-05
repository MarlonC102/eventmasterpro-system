package org.event.master.pro.person;

import java.util.ArrayList;
import java.util.List;

import static org.event.master.pro.util.Util.printMessage;

public class Artist extends Person{
    private String artisticName;
    private String requeriments;
    private double price;
    private String genre;
    private List<String> participationHistory;

    public Artist(String documentType, String documenNumbert, String name, String mail, String phone, String artisticName, String requeriments, double price, String genre) {
        super(documentType, documenNumbert, name, mail, phone);
        this.artisticName = artisticName;
        this.requeriments = requeriments;
        this.price = price;
        this.genre = genre;
        this.participationHistory = new ArrayList<>();
    }

    public String getArtisticName() {
        return artisticName;
    }

    public void setArtisticName(String artisticName) {
        this.artisticName = artisticName;
    }

    public String getRequeriments() {
        return requeriments;
    }

    public void setRequeriments(String requeriments) {
        this.requeriments = requeriments;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void addParticipation(String eventName) {
        participationHistory.add(eventName);
    }
    public void getTechRequirements(){
        printMessage(String.format("Technical Requirements for %s : %s",artisticName,requeriments));
    }
}
