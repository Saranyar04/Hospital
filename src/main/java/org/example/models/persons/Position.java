package org.example.models.persons;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "position")
@XmlType(propOrder = {"positionID", "name"})
public class Position {

    private int positionID;

    private String name;

    public Position() {
    }

    public Position(int positionID, String name) {
        this.positionID = positionID;
        this.name = name;
    }

    public int getPositionID() {
        return positionID;
    }

    @XmlAttribute(name = "positionID")
    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionID=" + positionID +
                ", name='" + name + '\'' +
                '}';
    }
}
