package org.example.services;

import org.example.interfaces.IDepartmentsDAO;
import org.example.jdbc.dao.DepartmentsDAO;
import org.example.models.hospital.Department;

import java.util.List;

public class DepartmentsService implements IDepartmentsDAO {

    private final DepartmentsDAO departmentsDAO = new DepartmentsDAO();
    @Override
    public void saveEntity(Department departments) {
        departmentsDAO.saveEntity(departments);
    }

    @Override
    public Department getEntityByID(int id) {
        return departmentsDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Department departments) {
        departmentsDAO.updateEntity(departments);
    }

    @Override
    public void removeEntityByID(int id) {
        departmentsDAO.removeEntityByID(id);
    }

    @Override
    public List<Department> getAll() {
        return departmentsDAO.getAll();
    }

    @Override
    public List<Department> getDepartmentOrderByName() {
        return departmentsDAO.getDepartmentOrderByName();
    }
}
