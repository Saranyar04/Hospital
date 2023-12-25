package org.example.models.persons;

public class Positions {

    private int positionID;
    private String name;

    public Positions() {
    }

    public Positions(int positionID, String name) {
        this.positionID = positionID;
        this.name = name;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Positions{" +
                "positionID=" + positionID +
                ", name='" + name + '\'' +
                '}';
    }
}
