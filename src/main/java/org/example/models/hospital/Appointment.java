package org.example.models.hospital;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.models.persons.Nurse;
import org.example.models.persons.Patient;
import org.example.models.persons.Physician;

import javax.xml.bind.annotation.*;


@XmlRootElement(name = "appointment")
@XmlType(propOrder = {"appointmentID", "startTime", "endTime", "patient", "physician", "nurse", "examinationRoom", "procedure"})
public class Appointment {

    @JsonProperty
    private int appointmentID;
    @JsonProperty
    private String startTime;
    @JsonProperty
    private String endTime;
    @JsonProperty
    private Patient patient;
    @JsonProperty
    private Physician physician;
    @JsonProperty
    private Nurse nurse;
    @JsonProperty
    private ExaminationRoom examinationRoom;
    @JsonProperty
    private Procedure procedure;

    public Appointment() {

    }

    public Appointment(int appointmentID, String startTime, String endTime, Patient patients, Physician physician, Nurse nurse, ExaminationRoom examinationRoom, Procedure procedure) {
        this.appointmentID = appointmentID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.patient = patients;
        this.physician = physician;
        this.nurse = nurse;
        this.examinationRoom = examinationRoom;
        this.procedure = procedure;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    @XmlAttribute(name = "appointmentID")
    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getStartTime() {
        return startTime;
    }

    @XmlElement(name = "startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    @XmlElement(name = "endTime")
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Patient getPatient() {
        return patient;
    }

    @XmlElement(name = "patient")
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Physician getPhysician() {
        return physician;
    }

    @XmlElement(name = "physician")
    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    public Nurse getNurse() {
        return nurse;
    }

    @XmlElement(name = "nurse")
    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public ExaminationRoom getExaminationRoom() {
        return examinationRoom;
    }

    @XmlElement(name = "examinationRoom")
    public void setExaminationRoom(ExaminationRoom examinationRoom) {
        this.examinationRoom = examinationRoom;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    @XmlElement(name = "procedure")
    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentID=" + appointmentID +
                ", startTime='" + startTime + '\'' +
                ", EndTime='" + endTime + '\'' +
                ", patient=" + patient +
                ", physician=" + physician +
                ", nurse=" + nurse +
                ", examinationRoom=" + examinationRoom +
                ", procedure=" + procedure +
                '}';
    }
}
