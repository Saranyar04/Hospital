package org.example.models.hospital;

public class Medication {

    private int medicationID;
    private String medicationName;
    private String details;
    private double amount;
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

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

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
