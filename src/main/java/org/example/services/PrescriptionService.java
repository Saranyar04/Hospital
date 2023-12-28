package org.example.services;

import org.example.interfaces.IPrescriptionDAO;
import org.example.jdbc.dao.PrescriptionDAO;
import org.example.models.hospital.Prescription;

import java.util.List;

public class PrescriptionService implements IPrescriptionDAO {

    private final PrescriptionDAO prescriptionDAO = new PrescriptionDAO();

    @Override
    public void saveEntity(Prescription prescription) {
        prescriptionDAO.saveEntity(prescription);
    }

    @Override
    public Prescription getEntityByID(int id) {
        return prescriptionDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Prescription prescription) {
        prescriptionDAO.updateEntity(prescription);
    }

    @Override
    public void removeEntityByID(int id) {
        prescriptionDAO.removeEntityByID(id);
    }

    @Override
    public List<Prescription> getAll() {
        return prescriptionDAO.getAll();
    }

    @Override
    public List<Prescription> getPrescriptionByPatientID(int patientID) {
        return prescriptionDAO.getPrescriptionByPatientID(patientID);
    }
}
