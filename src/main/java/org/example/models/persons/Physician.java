package org.example.models.persons;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.models.hospital.Department;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "physician")
@XmlType(propOrder = {"physicianID", "firstName", "lastName", "address", "department", "position", "specialization"})
public class Physician {

    @JsonProperty
    private int physicianID;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonIgnore
    private String address;
    @JsonProperty
    private Department department;
    @JsonProperty
    private Position position;
    @JsonProperty
    private Specialization specialization;

    public Physician() {
    }

    public Physician(int physicianID, String firstName, String lastName, String address, Department department, Position position, Specialization specialization) {
        this.physicianID = physicianID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.department = department;
        this.position = position;
        this.specialization = specialization;
    }

    public int getPhysicianID() {
        return physicianID;
    }

    @XmlAttribute(name = "physicianID")
    public void setPhysicianID(int physicianID) {
        this.physicianID = physicianID;
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

    public String getAddress() {
        return address;
    }

    @XmlElement(name = "address")
    public void setAddress(String address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    @XmlElement(name = "department")
    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    @XmlElement(name = "position")
    public void setPosition(Position position) {
        this.position = position;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    @XmlElement(name = "specialization")
    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Physicians{" +
                "physicianID=" + physicianID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", department=" + department +
                ", position=" + position +
                ", specialization=" + specialization +
                '}';
    }
}
