package org.example.models.persons;

import org.example.models.hospital.Department;

public class Physician {

    private int physicianID;
    private String firstName;
    private String lastName;
    private String address;
    private Department departments;
    private Position positions;
    private Specialization specializations;

    public Physician() {
    }

    public Physician(int physicianID, String firstName, String lastName, String address, Department departments, Position positions, Specialization specializations) {
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

    public Department getDepartments() {
        return departments;
    }

    public void setDepartments(Department departments) {
        this.departments = departments;
    }

    public Position getPositions() {
        return positions;
    }

    public void setPositions(Position positions) {
        this.positions = positions;
    }

    public Specialization getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Specialization specializations) {
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
