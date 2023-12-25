package org.example.interfaces;

import org.example.models.hospital.DepartmentsHasNurse;

import java.util.List;

public interface IDepartmentHasNurseDAO extends IBaseDAO<DepartmentsHasNurse> {

    List<DepartmentsHasNurse> getDepartmentByNurse(int nurseID);
}
