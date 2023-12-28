package org.example.services;

import org.example.interfaces.IMedicationDAO;
import org.example.jdbc.dao.MedicationDAO;
import org.example.models.hospital.Medication;

import java.util.List;

public class MedicationService implements IMedicationDAO {

    private final MedicationDAO medicationDAO = new MedicationDAO();

    @Override
    public void saveEntity(Medication medication) {
        medicationDAO.saveEntity(medication);
    }

    @Override
    public Medication getEntityByID(int id) {
        return medicationDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Medication medication) {
        medicationDAO.updateEntity(medication);
    }

    @Override
    public void removeEntityByID(int id) {
        medicationDAO.removeEntityByID(id);
    }

    @Override
    public List<Medication> getAll() {
        return medicationDAO.getAll();
    }

    @Override
    public List<Medication> getMedicationsByManufacturerID(int manufacturerID) {
        return medicationDAO.getMedicationsByManufacturerID(manufacturerID);
    }
}
