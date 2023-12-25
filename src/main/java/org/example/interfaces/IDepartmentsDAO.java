package org.example.interfaces;

import org.example.models.hospital.Departments;

import java.util.List;

public interface IDepartmentsDAO extends IBaseDAO<Departments> {
    public List<Departments> getDepartmentOrderByName();
}
