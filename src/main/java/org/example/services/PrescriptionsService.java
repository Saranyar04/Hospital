package org.example.services;

import org.example.interfaces.IPrescriptionsDAO;
import org.example.jdbc.dao.PrescriptionsDAO;
import org.example.models.hospital.Prescription;

import java.util.List;

public class PrescriptionsService implements IPrescriptionsDAO {

    private final PrescriptionsDAO prescriptionsDAO = new PrescriptionsDAO();

    @Override
    public void saveEntity(Prescription prescription) {
        prescriptionsDAO.saveEntity(prescription);
    }

    @Override
    public Prescription getEntityByID(int id) {
        return prescriptionsDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Prescription prescription) {
        prescriptionsDAO.updateEntity(prescription);
    }

    @Override
    public void removeEntityByID(int id) {
        prescriptionsDAO.removeEntityByID(id);
    }

    @Override
    public List<Prescription> getAll() {
        return prescriptionsDAO.getAll();
    }

    @Override
    public List<Prescription> getPrescriptionByPatientID(int patientID) {
        return prescriptionsDAO.getPrescriptionByPatientID(patientID);
    }
}
