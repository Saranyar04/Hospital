package org.example.models.hospital;

import org.example.models.persons.Patient;
import org.example.models.persons.Physician;

import java.util.Date;

public class Prescription {

    private int prescriptionID;
    private Date date;
    private Physician physician;
    private Patient patient;
    private Medication medication;

    public Prescription() {
    }

    public Prescription(int prescriptionID, Date date, Physician physician, Patient patient, Medication medication) {
        this.prescriptionID = prescriptionID;
        this.date = date;
        this.physician = physician;
        this.patient = patient;
        this.medication = medication;
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

    public Physician getPhysician() {
        return physician;
    }

    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "prescriptionID=" + prescriptionID +
                ", date=" + date +
                ", physician=" + physician +
                ", patient=" + patient +
                ", medication=" + medication +
                '}';
    }
}
