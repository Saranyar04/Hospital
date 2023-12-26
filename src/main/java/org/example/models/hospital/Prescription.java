package org.example.models.hospital;

import org.example.models.persons.Patients;
import org.example.models.persons.Physicians;

import java.util.Date;

public class Prescriptions {

    private int prescriptionID;
    private Date date;
    private Physicians physicians;
    private Patients patients;
    private Medications medications;

    public Prescriptions() {
    }

    public Prescriptions(int prescriptionID, Date date, Physicians physicians, Patients patients, Medications medications) {
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

    public Physicians getPhysicians() {
        return physicians;
    }

    public void setPhysicians(Physicians physicians) {
        this.physicians = physicians;
    }

    public Patients getPatients() {
        return patients;
    }

    public void setPatients(Patients patients) {
        this.patients = patients;
    }

    public Medications getMedications() {
        return medications;
    }

    public void setMedications(Medications medications) {
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
