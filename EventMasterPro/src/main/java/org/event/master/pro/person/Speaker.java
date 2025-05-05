package org.event.master.pro.person;

import java.util.ArrayList;
import java.util.List;

import static org.event.master.pro.util.Util.printMessage;

public class Speaker extends Person{
    private String speciality;
    private List<String> topic;
    private String requeriments;

    public Speaker(String documentType, String documenNumbert, String name, String mail, String phone, String speciality, List<String> topic, String requeriments) {
        super(documentType, documenNumbert, name, mail, phone);
        this.speciality = speciality;
        this.topic = new ArrayList<>(topic);
        this.requeriments = requeriments;
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

    public String getRequeriments() {
        return requeriments;
    }

    public void setRequeriments(String requeriments) {
        this.requeriments = requeriments;
    }

    public void getSpeakerInfo(){
        printMessage(String.format(
                "Speaker: %s\nSpecialty: %s\nTopics: %s\nRequirements: %s",
                getName(),
                speciality,
                String.join(", ", topic),
                requeriments
        ));
    }
    public void getTechRequirements(){
        printMessage(String.format("Technical Requirements for %s : %s",getName(),requeriments));
    }

}
