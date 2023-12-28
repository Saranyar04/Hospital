package org.example.interfaces;

import org.example.models.hospital.Department;

import java.util.List;

public interface IDepartmentDAO extends IBaseDAO<Department> {

    public List<Department> getDepartmentSortedByName();
}
