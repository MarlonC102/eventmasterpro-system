package org.event.master.pro.person.artist;

import java.util.List;
import org.event.master.pro.person.person.Person;

import static org.event.master.pro.util.Util.printMessage;
import org.event.master.pro.util.sql.Insert;
import org.event.master.pro.util.sql.Select;
import org.event.master.pro.util.sql.Update;

public class Artist extends Person {

    private String artisticName;
    private String requirements;
    private double price;
    private String genre;
    private List<String> participationHistory;
    private boolean availability;
    private boolean type;
    private int idArtist;

    public Artist() {
    }

    public Artist(int idArtist, double price, String artisticName) {
        this.idArtist = idArtist;
        this.price = price;
        this.artisticName = artisticName;
    }

    public Artist(String documentType, String documenNumber, String name, String genre, double price, boolean availability) {
        super(name, documentType, documenNumber);
        this.genre = genre;
        this.price = price;
        this.availability = availability;
    }

    public Artist(String documentType, String documenNumber, String name, String genre, double price, boolean availability, int idArtist) {
        super(name, documentType, documenNumber);
        this.genre = genre;
        this.price = price;
        this.availability = availability;
        this.idArtist = idArtist;
        this.artisticName = name;
    }

    public Artist(String documenNumber, String name, String mail, String phone, String requirements, double price, String genre, boolean availability) {
        super(documenNumber, name, mail, phone);
        this.requirements = requirements;
        this.price = price;
        this.genre = genre;
        this.availability = availability;
    }

    public Artist(String documenNumber, String name, String mail, String phone, String requirements, double price, String genre, boolean availability, String id) {
        super(documenNumber, name, mail, phone, id);
        this.requirements = requirements;
        this.price = price;
        this.genre = genre;
        this.availability = availability;
    }

    public String getArtisticName() {
        return artisticName;
    }

    public void setArtisticName(String artisticName) {
        this.artisticName = artisticName;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requeriments) {
        this.requirements = requeriments;
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

    public void getTechRequirements() {
        printMessage(String.format("Technical Requirements for %s : %s", artisticName, requirements));
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public int getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(int idArtist) {
        this.idArtist = idArtist;
    }

    public void setIdLocation(int idArtist) {
        this.idArtist = idArtist;
    }

    @Override
    public String toString() {
        return artisticName;
    }

}
