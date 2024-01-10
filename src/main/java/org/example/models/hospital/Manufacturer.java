package org.example.models.hospital;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "manufacturer")
@XmlType(propOrder = {"manufacturerID", "name", "address"})
public class Manufacturer {

    @JsonProperty
    private int manufacturerID;
    @JsonProperty
    private String name;
    @JsonProperty
    private String address;

    public Manufacturer() {
    }

    public Manufacturer(int manufacturerID, String name, String address) {
        this.manufacturerID = manufacturerID;
        this.name = name;
        this.address = address;
    }

    public int getManufacturerID() {
        return manufacturerID;
    }

    @XmlAttribute(name = "manufacturerID")
    public void setManufacturerID(int manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    @XmlElement(name = "address")
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "manufacturerID=" + manufacturerID +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
