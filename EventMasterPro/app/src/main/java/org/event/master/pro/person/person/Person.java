package org.event.master.pro.person.person;

public class Person {

    private String documentType;
    private String documenNumber;
    private String name;
    private String mail;
    private String phone;
    private boolean status;
    private String idPerson;
    private static String id;

    public Person() {

    }

    /* public Person(String documentType, String documenNumber, String name, String mail, String phone) {
        this.documentType = documentType;
        this.documenNumber = documenNumber;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
    }
     */
    public Person(String documenNumber, String name, String mail, String phone) {
        this.documenNumber = documenNumber;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
    }

    public Person(String name, String documenNumber) {
        this.name = name;
        this.documenNumber = documenNumber;
    }

    public Person(String name, String documenType, String documenNumber) {
        this.name = name;
        this.documentType = documenType;
        this.documenNumber = documenNumber;
    }

    public Person(String documentType, String documenNumber, String name, String mail, String idPerson) {
        this.documentType = documentType;
        this.documenNumber = documenNumber;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.idPerson = idPerson;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumenNumber() {
        return documenNumber;
    }

    public void setDocumenNumber(String documenNumbert) {
        this.documenNumber = documenNumbert;
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

    public String getIdPerson() {
        return idPerson;
    }

    public void setIdLocation(String idPerson) {
        this.idPerson = idPerson;
    }

    @Override
    public String toString() {
        return name;
    }

    public void updatePerson() {

    }

    public void changeStatusPerson() {
        status = false;
    }

    public void consultPerson() {

    }
}
