package org.example.models.persons;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "specialization")
@XmlType(propOrder = {"specializationID", "name"})
public class Specialization {

    @JsonProperty
    private int specializationID;
    @JsonProperty
    private String name;

    public Specialization() {
    }

    public Specialization(int specializationID, String name) {
        this.specializationID = specializationID;
        this.name = name;
    }

    public int getSpecializationID() {
        return specializationID;
    }

    @XmlAttribute(name = "specializationID")
    public void setSpecializationID(int specializationID) {
        this.specializationID = specializationID;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Specializations{" +
                "specializationID=" + specializationID +
                ", name='" + name + '\'' +
                '}';
    }
}
