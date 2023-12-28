package org.example.services;

import org.example.interfaces.IMedicationsDAO;
import org.example.jdbc.dao.MedicationsDAO;
import org.example.models.hospital.Medication;

import java.util.List;

public class MedicationsService implements IMedicationsDAO {

    private final MedicationsDAO medicationsDAO = new MedicationsDAO();

    @Override
    public void saveEntity(Medication medication) {
        medicationsDAO.saveEntity(medication);
    }

    @Override
    public Medication getEntityByID(int id) {
        return medicationsDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Medication medication) {
        medicationsDAO.updateEntity(medication);
    }

    @Override
    public void removeEntityByID(int id) {
        medicationsDAO.removeEntityByID(id);
    }

    @Override
    public List<Medication> getAll() {
        return medicationsDAO.getAll();
    }

    @Override
    public List<Medication> getMedicationsByManufacturerID(int manufacturerID) {
        return medicationsDAO.getMedicationsByManufacturerID(manufacturerID);
    }
}
