package org.example.models.hospital;

public class Procedures {

    private int procedureID;
    private String name;
    private Double cost;
    private String description;

    public Procedures() {
    }

    public Procedures(int procedureID, String name, Double cost, String description) {
        this.procedureID = procedureID;
        this.name = name;
        this.cost = cost;
        this.description = description;
    }

    public int getProcedureID() {
        return procedureID;
    }

    public void setProcedureID(int procedureID) {
        this.procedureID = procedureID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Procedures{" +
                "procedureID=" + procedureID +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                '}';
    }
}
