package org.example.models.hospital;

import org.example.models.persons.Patient;
import org.example.models.persons.Physician;

import java.util.Date;

public class Prescription {

    private int prescriptionID;
    private Date date;
    private Physician physicians;
    private Patient patients;
    private Medication medications;

    public Prescription() {
    }

    public Prescription(int prescriptionID, Date date, Physician physicians, Patient patients, Medication medications) {
        this.prescriptionID = prescriptionID;
        this.date = date;
        this.physicians = physicians;
        this.patients = patients;
        this.medications = medications;
    }

    public int getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public java.sql.Date getDate() {
        return (java.sql.Date) date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Physician getPhysicians() {
        return physicians;
    }

    public void setPhysicians(Physician physicians) {
        this.physicians = physicians;
    }

    public Patient getPatients() {
        return patients;
    }

    public void setPatients(Patient patients) {
        this.patients = patients;
    }

    public Medication getMedications() {
        return medications;
    }

    public void setMedications(Medication medications) {
        this.medications = medications;
    }

    @Override
    public String toString() {
        return "Prescriptions{" +
                "prescriptionID=" + prescriptionID +
                ", date=" + date +
                ", physicians=" + physicians +
                ", patients=" + patients +
                ", medications=" + medications +
                '}';
    }
}
