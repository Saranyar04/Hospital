package org.example.models.persons;

import org.example.jaxb.DateAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlRootElement(name = "patient")
@XmlType(propOrder = {"patientID", "firstName", "lastName", "dateOfBirth", "address", "physician"})
public class Patient {

    private int patientID;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String address;
    private Physician physician;

    public Patient() {
    }

    public Patient(int patientID, String firstName, String lastName, Date dateOfBirth, String address, Physician physician) {
        this.patientID = patientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.physician = physician;
    }

    public int getPatientID() {
        return patientID;
    }

    @XmlAttribute(name = "patientID")
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getFirstName() {
        return firstName;
    }

    @XmlElement(name = "firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @XmlElement(name = "lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @XmlElement(name = "dateOfBirth")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    @XmlElement(name = "address")
    public void setAddress(String address) {
        this.address = address;
    }

    public Physician getPhysician() {
        return physician;
    }

    @XmlElement(name = "physician")
    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientID=" + patientID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", physician=" + physician +
                '}';
    }
}
