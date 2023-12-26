package org.example.models.hospital;

import org.example.models.persons.Nurse;
import org.example.models.persons.Patient;
import org.example.models.persons.Physician;

public class Appointment {

    private int appointmantID;
    private String startTime;
    private String EndTime;
    private Patient patients;
    private Physician physicians;
    private Nurse nurses;
    private ExaminationRoom examinationRooms;
    private Procedure procedures;

    public Appointment() {
    }

    public Appointment(int appointmantID, String startTime, String endTime, Patient patients, Physician physicians, Nurse nurses, ExaminationRoom examinationRooms, Procedure procedures) {
        this.appointmantID = appointmantID;
        this.startTime = startTime;
        EndTime = endTime;
        this.patients = patients;
        this.physicians = physicians;
        this.nurses = nurses;
        this.examinationRooms = examinationRooms;
        this.procedures = procedures;
    }

    public int getAppointmantID() {
        return appointmantID;
    }

    public void setAppointmantID(int appointmantID) {
        this.appointmantID = appointmantID;
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

    public Patient getPatients() {
        return patients;
    }

    public void setPatients(Patient patients) {
        this.patients = patients;
    }

    public Physician getPhysicians() {
        return physicians;
    }

    public void setPhysicians(Physician physicians) {
        this.physicians = physicians;
    }

    public Nurse getNurses() {
        return nurses;
    }

    public void setNurses(Nurse nurses) {
        this.nurses = nurses;
    }

    public ExaminationRoom getExaminationRooms() {
        return examinationRooms;
    }

    public void setExaminationRooms(ExaminationRoom examinationRooms) {
        this.examinationRooms = examinationRooms;
    }

    public Procedure getProcedures() {
        return procedures;
    }

    public void setProcedures(Procedure procedures) {
        this.procedures = procedures;
    }

    @Override
    public String toString() {
        return "Appointments{" +
                "appointmantID=" + appointmantID +
                ", startTime='" + startTime + '\'' +
                ", EndTime='" + EndTime + '\'' +
                ", patients=" + patients +
                ", physicians=" + physicians +
                ", nurses=" + nurses +
                ", examinationRooms=" + examinationRooms +
                ", procedures=" + procedures +
                '}';
    }
}
