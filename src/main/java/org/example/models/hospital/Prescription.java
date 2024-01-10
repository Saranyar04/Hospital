package org.example.models.hospital;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.models.persons.Patient;
import org.example.models.persons.Physician;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlRootElement(name = "prescription")
@XmlType(propOrder = {"prescriptionID", "date", "physician", "patient", "medication"})
public class Prescription {

    @JsonProperty
    private int prescriptionID;

    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private Date date;

    @JsonProperty
    private Physician physician;

    @JsonProperty
    private Patient patient;

    @JsonProperty
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

    @XmlAttribute(name = "prescriptionID")
    public void setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public java.sql.Date getDate() {
        return (java.sql.Date) date;
    }

    @XmlElement(name = "date")
    public void setDate(Date date) {
        this.date = date;
    }

    public Physician getPhysician() {
        return physician;
    }

    @XmlElement(name = "physician")
    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    public Patient getPatient() {
        return patient;
    }

    @XmlElement(name = "patient")
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medication getMedication() {
        return medication;
    }

    @XmlElement(name = "medication")
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
