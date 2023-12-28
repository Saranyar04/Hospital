package org.example.models.hospital;

import org.example.models.persons.Nurse;
import org.example.models.persons.Patient;
import org.example.models.persons.Physician;

public class Appointment {

    private int appointmentID;
    private String startTime;
    private String EndTime;
    private Patient patient;
    private Physician physician;
    private Nurse nurse;
    private ExaminationRoom examinationRoom;
    private Procedure procedure;

    public Appointment() {
    }

    public Appointment(int appointmentID, String startTime, String endTime, Patient patients, Physician physician, Nurse nurse, ExaminationRoom examinationRoom, Procedure procedure) {
        this.appointmentID = appointmentID;
        this.startTime = startTime;
        EndTime = endTime;
        this.patient = patients;
        this.physician = physician;
        this.nurse = nurse;
        this.examinationRoom = examinationRoom;
        this.procedure = procedure;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Physician getPhysician() {
        return physician;
    }

    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public ExaminationRoom getExaminationRoom() {
        return examinationRoom;
    }

    public void setExaminationRoom(ExaminationRoom examinationRoom) {
        this.examinationRoom = examinationRoom;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentID=" + appointmentID +
                ", startTime='" + startTime + '\'' +
                ", EndTime='" + EndTime + '\'' +
                ", patient=" + patient +
                ", physician=" + physician +
                ", nurse=" + nurse +
                ", examinationRoom=" + examinationRoom +
                ", procedure=" + procedure +
                '}';
    }
}
