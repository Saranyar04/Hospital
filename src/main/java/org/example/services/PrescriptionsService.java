package org.example.services;

import org.example.interfaces.IPrescriptionsDAO;
import org.example.jdbc.dao.PrescriptionsDAO;
import org.example.models.hospital.Prescription;

import java.util.List;

public class PrescriptionsService implements IPrescriptionsDAO {

    private final PrescriptionsDAO prescriptionsDAO = new PrescriptionsDAO();

    @Override
    public void saveEntity(Prescription prescriptions) {
        prescriptionsDAO.saveEntity(prescriptions);
    }

    @Override
    public Prescription getEntityByID(int id) {
        return prescriptionsDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Prescription prescriptions) {
        prescriptionsDAO.updateEntity(prescriptions);
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
    public List<Prescription> getPrescriptionByPatient(int patientID) {
        return prescriptionsDAO.getPrescriptionByPatient(patientID);
    }
}
