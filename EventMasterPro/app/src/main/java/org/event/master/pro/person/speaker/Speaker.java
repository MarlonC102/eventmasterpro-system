package org.event.master.pro.person.speaker;

import java.util.List;
import org.event.master.pro.person.person.Person;
public class Speaker extends Person{
    private String speciality;
    private List<String> topic;
    private String requirements;
    private double price;
    boolean availability;
    private int idSpeaker;

    public Speaker(){}
    
    public Speaker (String documenNumber, String name, double price, boolean availability, String speciality, int idSpeaker){
        super(name, documenNumber);
        this.speciality = speciality;
        this.price = price;
        this.availability = availability;
        this.availability = availability;
    }

    public Speaker(String documenNumber, String name, String mail, String phone, String requirements, double price, String speciality, boolean availability) {
        super( documenNumber, name, mail, phone);
        this.requirements = requirements;
        this.price = price;
        this.speciality = speciality;
        this.availability = availability;
    }
    
    public Speaker(String documenNumber, String name, String mail, String phone, String requirements, double price, String speciality, boolean availability, int idSpeaker) {
        super( documenNumber, name, mail, phone);
        this.requirements = requirements;
        this.price = price;
        this.speciality = speciality;
        this.availability = availability;
        this.idSpeaker = idSpeaker;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public List<String> getTopic() {
        return topic;
    }

    public void setTopic(List<String> topic) {
        this.topic = topic;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getIdSpeaker() {
        return idSpeaker;
    }

    public void setIdSpeaker(int idSpeaker) {
        this.idSpeaker = idSpeaker;
    }
    
    
    
    

    

}
