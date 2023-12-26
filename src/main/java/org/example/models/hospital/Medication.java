package org.example.models.hospital;

public class Medication {

    private int medicationID;
    private String medicationName;
    private String details;
    private double amount;
    private Manufacturer manufacturers;

    public Medication() {
    }

    public Medication(int medicationID, String medicationName, String details, double amount, Manufacturer manufacturers) {
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

    public Manufacturer getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(Manufacturer manufacturers) {
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
