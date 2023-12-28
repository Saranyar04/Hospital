package org.example.models.persons;

public class Nurse {

    private int nurseID;
    private String firstName;
    private String lastName;
    private Position position;

    public Nurse() {
    }

    public Nurse(int nurseID, String firstName, String lastName, Position position) {
        this.nurseID = nurseID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "nurseID=" + nurseID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", positions=" + position +
                '}';
    }
}
