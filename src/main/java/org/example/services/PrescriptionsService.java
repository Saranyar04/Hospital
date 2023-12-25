package org.example.services;

import org.example.interfaces.IPrescriptionsDAO;
import org.example.jdbc.dao.PrescriptionsDAO;
import org.example.models.hospital.Prescriptions;

import java.util.List;

public class PrescriptionsService implements IPrescriptionsDAO {

    private final PrescriptionsDAO prescriptionsDAO = new PrescriptionsDAO();

    @Override
    public void saveEntity(Prescriptions prescriptions) {
        prescriptionsDAO.saveEntity(prescriptions);
    }

    @Override
    public Prescriptions getEntityByID(int id) {
        return prescriptionsDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Prescriptions prescriptions) {
        prescriptionsDAO.updateEntity(prescriptions);
    }

    @Override
    public void removeEntityByID(int id) {
        prescriptionsDAO.removeEntityByID(id);
    }

    @Override
    public List<Prescriptions> getAll() {
        return prescriptionsDAO.getAll();
    }

    @Override
    public List<Prescriptions> getPrescriptionByPatient(int patientID) {
        return prescriptionsDAO.getPrescriptionByPatient(patientID);
    }
}
