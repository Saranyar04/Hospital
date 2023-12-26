package org.example.services;

import org.example.interfaces.IPhysiciansDAO;
import org.example.jdbc.dao.PhysiciansDAO;
import org.example.models.persons.Physician;

import java.util.List;

public class PhysiciansService implements IPhysiciansDAO {

    private final PhysiciansDAO physiciansDAO = new PhysiciansDAO();

    @Override
    public void saveEntity(Physician physicians) {
        physiciansDAO.saveEntity(physicians);
    }

    @Override
    public Physician getEntityByID(int id) {
        return physiciansDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Physician physicians) {
        physiciansDAO.updateEntity(physicians);
    }

    @Override
    public void removeEntityByID(int id) {
        physiciansDAO.removeEntityByID(id);
    }

    @Override
    public List<Physician> getAll() {
        return physiciansDAO.getAll();
    }

    @Override
    public String getAddressByID(int departmentID) {
        return physiciansDAO.getAddressByID(departmentID);
    }
}
