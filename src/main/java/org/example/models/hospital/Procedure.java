package org.example.models.hospital;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "procedure")
@XmlType(propOrder = {"procedureID", "name", "cost", "description"})
public class Procedure {

    private int procedureID;
    private String name;
    private Double cost;
    private String description;

    public Procedure() {
    }

    public Procedure(int procedureID, String name, Double cost, String description) {
        this.procedureID = procedureID;
        this.name = name;
        this.cost = cost;
        this.description = description;
    }

    public int getProcedureID() {
        return procedureID;
    }

    @XmlAttribute(name = "procedureID")
    public void setProcedureID(int procedureID) {
        this.procedureID = procedureID;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    @XmlAttribute(name = "cost")
    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    @XmlAttribute(name = "description")
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Procedure{" +
                "procedureID=" + procedureID +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                '}';
    }
}
