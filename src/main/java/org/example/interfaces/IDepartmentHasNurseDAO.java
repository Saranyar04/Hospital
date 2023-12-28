package org.example.interfaces;

import org.example.models.hospital.Department;
import org.example.models.hospital.DepartmentsHasNurse;
import org.example.models.persons.Nurse;

import java.util.List;

public interface IDepartmentHasNurseDAO extends IBaseDAO<DepartmentsHasNurse> {

    List<DepartmentsHasNurse> getDepartmentByNurseID(int nurseID);
    List<Nurse> getNursesByDepartment(Department department);
}
