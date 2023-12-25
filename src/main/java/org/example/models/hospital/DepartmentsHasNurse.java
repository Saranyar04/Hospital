package org.example.models.hospital;

import org.example.models.hospital.Departments;
import org.example.models.persons.Nurses;

public class DepartmentsHasNurse {

    private Departments departments;
    private Nurses nurses;

    public DepartmentsHasNurse() {
    }

    public DepartmentsHasNurse(Departments departments, Nurses nurses) {
        this.departments = departments;
        this.nurses = nurses;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public Nurses getNurses() {
        return nurses;
    }

    public void setNurses(Nurses nurses) {
        this.nurses = nurses;
    }

    @Override
    public String toString() {
        return "DepartmentsHasNurse{" +
                "departments=" + departments +
                ", nurses=" + nurses +
                '}';
    }
}
