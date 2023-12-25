package org.example.models.persons;

import org.example.models.hospital.Departments;

public class Physicians {

    private int physicianID;
    private String firstName;
    private String lastName;
    private String address;
    private Departments departments;
    private Positions positions;
    private Specializations specializations;

    public Physicians() {
    }

    public Physicians(int physicianID, String firstName, String lastName, String address, Departments departments, Positions positions, Specializations specializations) {
        this.physicianID = physicianID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.departments = departments;
        this.positions = positions;
        this.specializations = specializations;
    }

    public int getPhysicianID() {
        return physicianID;
    }

    public void setPhysicianID(int physicianID) {
        this.physicianID = physicianID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public Positions getPositions() {
        return positions;
    }

    public void setPositions(Positions positions) {
        this.positions = positions;
    }

    public Specializations getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Specializations specializations) {
        this.specializations = specializations;
    }

    @Override
    public String toString() {
        return "Physicians{" +
                "physicianID=" + physicianID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", departments=" + departments +
                ", positions=" + positions +
                ", specializations=" + specializations +
                '}';
    }
}
