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
    @XmlAttribute(name = "specializationID")
    private int specializationID;

    @JsonProperty
    @XmlElement(name = "name")
    private String name;

    public  Specialization() {
    }

    public Specialization(int specializationId, String name) {
    }

    public Specialization(Builder builder) {
        this.specializationID = builder.specializationID;
        this.name = builder.name;
    }

    public static class Builder {
        private int specializationID;
        private String name;

        public Builder(int specializationID) {
            this.specializationID = specializationID;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Specialization build() {
            return new Specialization(this);
        }
    }

    public int getSpecializationID() {
        return specializationID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Specializations{" +
                "specializationID=" + specializationID +
                ", name='" + name + '\'' +
                '}';
    }
}
