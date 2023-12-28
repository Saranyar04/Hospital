package org.example.models.persons;

public class Specialization {

    private int specializationID;
    private String name;

    public Specialization() {
    }

    public Specialization(int specializationID, String name) {
        this.specializationID = specializationID;
        this.name = name;
    }

    public int getSpecializationID() {
        return specializationID;
    }

    public void setSpecializationID(int specializationID) {
        this.specializationID = specializationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Specializations{" +
                "specializationID=" + specializationID +
                ", name='" + name + '\'' +
                '}';
    }
}
