package org.event.master.pro.person;

import java.util.List;

public class Speaker extends Person{
    private String speciality;
    private List<String> topic;

    public Speaker(String documentType, String documenNumbert, String name, String mail, String phone, boolean status) {
        super(documentType, documenNumbert, name, mail, phone);
    }

    public void getSpeakerInfo(){}
    public void getTechRequirements(){}

}
