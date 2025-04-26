package org.event.master.pro.person;

public class Person {
    private String documentType;
    private String documenNumbert;
    private String name;
    private String mail;
    private String phone;
    private boolean status;

    public Person(String documentType, String documenNumbert, String name, String mail, String phone) {
        this.documentType = documentType;
        this.documenNumbert = documenNumbert;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.status = true;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumenNumbert() {
        return documenNumbert;
    }

    public void setDocumenNumbert(String documenNumbert) {
        this.documenNumbert = documenNumbert;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void updatePerson(){

    }
    public void changeStatusPerson(){
        status = false;
    }
    public void consultPerson(){

    }
}
