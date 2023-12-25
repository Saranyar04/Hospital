package org.example.models.hospital;

import org.example.models.persons.Nurses;
import org.example.models.persons.Patients;
import org.example.models.persons.Physicians;

public class Appointments {

    private int appointmantID;
    private String startTime;
    private String EndTime;
    private Patients patients;
    private Physicians physicians;
    private Nurses nurses;
    private ExaminationRooms examinationRooms;
    private Procedures procedures;

    public Appointments() {
    }

    public Appointments(int appointmantID, String startTime, String endTime, Patients patients, Physicians physicians, Nurses nurses, ExaminationRooms examinationRooms, Procedures procedures) {
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

    public Patients getPatients() {
        return patients;
    }

    public void setPatients(Patients patients) {
        this.patients = patients;
    }

    public Physicians getPhysicians() {
        return physicians;
    }

    public void setPhysicians(Physicians physicians) {
        this.physicians = physicians;
    }

    public Nurses getNurses() {
        return nurses;
    }

    public void setNurses(Nurses nurses) {
        this.nurses = nurses;
    }

    public ExaminationRooms getExaminationRooms() {
        return examinationRooms;
    }

    public void setExaminationRooms(ExaminationRooms examinationRooms) {
        this.examinationRooms = examinationRooms;
    }

    public Procedures getProcedures() {
        return procedures;
    }

    public void setProcedures(Procedures procedures) {
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
