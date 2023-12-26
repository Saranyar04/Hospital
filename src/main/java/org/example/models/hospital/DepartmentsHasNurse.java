package org.example.models.hospital;

import org.example.models.persons.Nurse;

public class DepartmentsHasNurse {

    private Department departments;
    private Nurse nurses;

    public DepartmentsHasNurse() {
    }

    public DepartmentsHasNurse(Department departments, Nurse nurses) {
        this.departments = departments;
        this.nurses = nurses;
    }

    public Department getDepartments() {
        return departments;
    }

    public void setDepartments(Department departments) {
        this.departments = departments;
    }

    public Nurse getNurses() {
        return nurses;
    }

    public void setNurses(Nurse nurses) {
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
