package org.example.models.persons;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "nurse")
@XmlType(propOrder = {"nurseID", "firstName", "lastName", "position"})
public class Nurse {

    @JsonProperty
    private int nurseID;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;

    @JsonProperty
    private Position position;

    public Nurse() {
    }

    public Nurse(int nurseID, String firstName, String lastName, Position position) {
        this.nurseID = nurseID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public int getNurseID() {
        return nurseID;
    }

    @XmlAttribute(name = "nurseID")
    public void setNurseID(int nurseID) {
        this.nurseID = nurseID;
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

    public Position getPosition() {
        return position;
    }

    @XmlElement(name = "position")
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "nurseID=" + nurseID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", positions=" + position +
                '}';
    }
}
