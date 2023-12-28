package org.example.services;

import org.example.interfaces.IDepartmentDAO;
import org.example.jdbc.dao.DepartmentDAO;
import org.example.models.hospital.Department;

import java.util.List;

public class DepartmentService implements IDepartmentDAO {

    private final DepartmentDAO departmentDAO = new DepartmentDAO();
    @Override
    public void saveEntity(Department departments) {
        departmentDAO.saveEntity(departments);
    }

    @Override
    public Department getEntityByID(int id) {
        return departmentDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Department departments) {
        departmentDAO.updateEntity(departments);
    }

    @Override
    public void removeEntityByID(int id) {
        departmentDAO.removeEntityByID(id);
    }

    @Override
    public List<Department> getAll() {
        return departmentDAO.getAll();
    }

    @Override
    public List<Department> getDepartmentSortedByName() {
        return departmentDAO.getDepartmentSortedByName();
    }
}
