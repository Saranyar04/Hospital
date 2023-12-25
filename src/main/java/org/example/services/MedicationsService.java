package org.example.services;

import org.example.interfaces.IMedicationsDAO;
import org.example.jdbc.dao.MedicationsDAO;
import org.example.models.hospital.Medications;

import java.util.List;

public class MedicationsService implements IMedicationsDAO {

    private final MedicationsDAO medicationsDAO = new MedicationsDAO();

    @Override
    public void saveEntity(Medications medications) {
        medicationsDAO.saveEntity(medications);
    }

    @Override
    public Medications getEntityByID(int id) {
        return medicationsDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Medications medications) {
        medicationsDAO.updateEntity(medications);
    }

    @Override
    public void removeEntityByID(int id) {
        medicationsDAO.removeEntityByID(4);
    }

    @Override
    public List<Medications> getAll() {
        return medicationsDAO.getAll();
    }

    @Override
    public List<Medications> getMedicationsByManufacturer(int manufacturerID) {
        return medicationsDAO.getMedicationsByManufacturer(manufacturerID);
    }
}
