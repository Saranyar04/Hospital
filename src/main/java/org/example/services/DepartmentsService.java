package org.example.services;

import org.example.interfaces.IDepartmentsDAO;
import org.example.jdbc.dao.DepartmentsDAO;
import org.example.models.hospital.Departments;

import java.util.List;

public class DepartmentsService implements IDepartmentsDAO {

    private final DepartmentsDAO departmentsDAO = new DepartmentsDAO();
    @Override
    public void saveEntity(Departments departments) {
        departmentsDAO.saveEntity(departments);
    }

    @Override
    public Departments getEntityByID(int id) {
        return departmentsDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Departments departments) {
        departmentsDAO.updateEntity(departments);
    }

    @Override
    public void removeEntityByID(int id) {
        departmentsDAO.removeEntityByID(id);
    }

    @Override
    public List<Departments> getAll() {
        return departmentsDAO.getAll();
    }

    @Override
    public List<Departments> getDepartmentOrderByName() {
        return departmentsDAO.getDepartmentOrderByName();
    }
}
