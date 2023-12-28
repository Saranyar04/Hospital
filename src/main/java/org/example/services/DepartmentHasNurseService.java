package org.example.services;

import org.example.interfaces.IDepartmentHasNurseDAO;
import org.example.jdbc.dao.DepartmentHasNurseDAO;
import org.example.models.hospital.Department;
import org.example.models.hospital.DepartmentsHasNurse;
import org.example.models.persons.Nurse;

import java.util.List;

public class DepartmentHasNurseService implements IDepartmentHasNurseDAO {

    private final DepartmentHasNurseDAO departmentHasNurseDAO = new DepartmentHasNurseDAO();

    @Override
    public void saveEntity(DepartmentsHasNurse departmentsHasNurse) {
        departmentHasNurseDAO.saveEntity(departmentsHasNurse);
    }

    @Override
    public DepartmentsHasNurse getEntityByID(int id) {
        return departmentHasNurseDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(DepartmentsHasNurse departmentsHasNurse) {
        departmentHasNurseDAO.updateEntity(departmentsHasNurse);
    }

    @Override
    public void removeEntityByID(int id) {
        departmentHasNurseDAO.removeEntityByID(id);
    }

    @Override
    public List<DepartmentsHasNurse> getAll() {
        return departmentHasNurseDAO.getAll();
    }

    @Override
    public List<DepartmentsHasNurse> getDepartmentByNurseID(int nurseID) {
        return departmentHasNurseDAO.getDepartmentByNurseID(nurseID);
    }

    @Override
    public List<Nurse> getNursesByDepartment(Department department) {
        return departmentHasNurseDAO.getNursesByDepartment(department);
    }
}
