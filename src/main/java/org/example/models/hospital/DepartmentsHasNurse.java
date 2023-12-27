package org.example.models.hospital;

import org.example.models.persons.Nurse;

public class DepartmentsHasNurse {

    private Department department;
    private Nurse nurse;

    public DepartmentsHasNurse() {
    }

    public DepartmentsHasNurse(Department departments, Nurse nurses) {
        this.department = departments;
        this.nurse = nurses;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    @Override
    public String toString() {
        return "DepartmentsHasNurse{" +
                "department=" + department +
                ", nurse=" + nurse +
                '}';
    }
}
