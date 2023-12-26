package org.example.models.persons;

public class Specialization {

    private int spcializationID;
    private String name;

    public Specialization() {
    }

    public Specialization(int spcializationID, String name) {
        this.spcializationID = spcializationID;
        this.name = name;
    }

    public int getSpcializationID() {
        return spcializationID;
    }

    public void setSpcializationID(int spcializationID) {
        this.spcializationID = spcializationID;
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
                "spcializationID=" + spcializationID +
                ", name='" + name + '\'' +
                '}';
    }
}
