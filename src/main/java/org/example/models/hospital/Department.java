package org.example.models.hospital;

public class Department {

    private int departmentID;
    private String name;

    public Department() {
    }

    public Department(int departmentID, String name) {
        this.departmentID = departmentID;
        this.name = name;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Departments{" +
                "departmentID=" + departmentID +
                ", name='" + name + '\'' +
                '}';
    }
}
