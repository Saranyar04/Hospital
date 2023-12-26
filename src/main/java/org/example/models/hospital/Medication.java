package org.example.models.hospital;

import org.example.models.hospital.Manufacturers;

public class Medications {

    private int medicationID;
    private String medicationName;
    private String details;
    private double amount;
    private Manufacturers manufacturers;

    public Medications() {
    }

    public Medications(int medicationID, String medicationName, String details, double amount, Manufacturers manufacturers) {
        this.medicationID = medicationID;
        this.medicationName = medicationName;
        this.details = details;
        this.amount = amount;
        this.manufacturers = manufacturers;
    }

    public int getMedicationID() {
        return medicationID;
    }

    public void setMedicationID(int medicationID) {
        this.medicationID = medicationID;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Manufacturers getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(Manufacturers manufacturers) {
        this.manufacturers = manufacturers;
    }

    @Override
    public String toString() {
        return "Medications{" +
                "medicationID=" + medicationID +
                ", medicationName='" + medicationName + '\'' +
                ", details='" + details + '\'' +
                ", amount=" + amount +
                ", manufacturers=" + manufacturers +
                '}';
    }
}
