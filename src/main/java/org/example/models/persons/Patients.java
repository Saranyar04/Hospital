package org.example.models.persons;

import java.util.Date;

public class Patients {

    private int patientID;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String address;
    private Physicians physicians;

    public Patients() {
    }

    public Patients(int patientID, String firstName, String lastName, Date dateOfBirth, String address, Physicians physicians) {
        this.patientID = patientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.physicians = physicians;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public java.sql.Date getDateOfBirth() {
        return (java.sql.Date) dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Physicians getPhysicians() {
        return physicians;
    }

    public void setPhysicians(Physicians physicians) {
        this.physicians = physicians;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "patientID=" + patientID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", physicians=" + physicians +
                '}';
    }
}
