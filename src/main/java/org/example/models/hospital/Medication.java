package org.example.models.hospital;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "medication")
@XmlType(propOrder = {"medicationID", "medicationName", "details", "amount", "manufacturer"})
public class Medication {

    @JsonProperty
    private int medicationID;

    @JsonProperty
    private String medicationName;

    @JsonProperty
    private String details;

    @JsonProperty
    private double amount;

    @JsonProperty
    private Manufacturer manufacturer;

    public Medication() {
    }

    public Medication(int medicationID, String medicationName, String details, double amount, Manufacturer manufacturer) {
        this.medicationID = medicationID;
        this.medicationName = medicationName;
        this.details = details;
        this.amount = amount;
        this.manufacturer = manufacturer;
    }

    public int getMedicationID() {
        return medicationID;
    }

    @XmlAttribute(name = "medicationID")
    public void setMedicationID(int medicationID) {
        this.medicationID = medicationID;
    }

    public String getMedicationName() {
        return medicationName;
    }
    @XmlElement(name = "medicationName")
    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDetails() {
        return details;
    }

    @XmlElement(name = "details")
    public void setDetails(String details) {
        this.details = details;
    }

    public double getAmount() {
        return amount;
    }

    @XmlElement(name = "amount")
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    @XmlElement(name = "manufacturer")
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "medicationID=" + medicationID +
                ", medicationName='" + medicationName + '\'' +
                ", details='" + details + '\'' +
                ", amount=" + amount +
                ", manufacturer=" + manufacturer +
                '}';
    }
}
