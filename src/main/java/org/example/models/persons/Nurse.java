package org.example.models.persons;

public class Nurse {

    private int nurseID;
    private String firstName;
    private String lastName;
    private Position positions;

    public Nurse() {
    }

    public Nurse(int nurseID, String firstName, String lastName, Position positions) {
        this.nurseID = nurseID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.positions = positions;
    }

    public int getNurseID() {
        return nurseID;
    }

    public void setNurseID(int nurseID) {
        this.nurseID = nurseID;
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

    public Position getPositions() {
        return positions;
    }

    public void setPositions(Position positions) {
        this.positions = positions;
    }

    @Override
    public String toString() {
        return "Nurses{" +
                "nurseID=" + nurseID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", positions=" + positions +
                '}';
    }
}
