package org.example.services;

import org.example.interfaces.IPhysicianDAO;
import org.example.jdbc.dao.PhysicianDAO;
import org.example.models.persons.Physician;

import java.util.List;

public class PhysicianService implements IPhysicianDAO {

    private final PhysicianDAO physicianDAO = new PhysicianDAO();

    @Override
    public void saveEntity(Physician physician) {
        physicianDAO.saveEntity(physician);
    }

    @Override
    public Physician getEntityByID(int id) {
        return physicianDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Physician physician) {
        physicianDAO.updateEntity(physician);
    }

    @Override
    public void removeEntityByID(int id) {
        physicianDAO.removeEntityByID(id);
    }

    @Override
    public List<Physician> getAll() {
        return physicianDAO.getAll();
    }

    @Override
    public String getAddressByID(int departmentID) {
        return physicianDAO.getAddressByID(departmentID);
    }
}
