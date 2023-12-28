package org.example.models.hospital;

import org.example.models.persons.Nurse;

import java.util.List;

public class Department {

    private int departmentID;
    private String name;
    private List<Nurse> nursesList;

    public Department() {
    }

    public Department(int departmentID, String name, List<Nurse> nursesList) {
        this.departmentID = departmentID;
        this.name = name;
        this.nursesList = nursesList;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Nurse> getNursesList() {
        return nursesList;
    }

    public void setNursesList(List<Nurse> nursesList) {
        this.nursesList = nursesList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID=" + departmentID +
                ", name='" + name + '\'' +
                ", nursesList=" + nursesList +
                '}';
    }
}
