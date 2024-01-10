package org.example.models.hospital;

import org.example.models.persons.Nurse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "departmentHasNurse")
@XmlType(propOrder = {"department", "nurse"})
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

    @XmlElement(name = "department")
    public void setDepartment(Department department) {
        this.department = department;
    }

    public Nurse getNurse() {
        return nurse;
    }

    @XmlElement(name = "nurse")
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
