package org.example.models.persons;

public class Nurses {

    private int nurseID;
    private String firstName;
    private String lastName;
    private Positions positions;

    public Nurses() {
    }

    public Nurses(int nurseID, String firstName, String lastName, Positions positions) {
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

    public Positions getPositions() {
        return positions;
    }

    public void setPositions(Positions positions) {
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
