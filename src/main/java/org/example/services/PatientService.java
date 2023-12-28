package org.example.services;

import org.example.interfaces.IPatientDAO;
import org.example.jdbc.dao.PatientDAO;
import org.example.models.persons.Patient;

import java.util.List;

public class PatientService implements IPatientDAO {

    private final PatientDAO patientDAO = new PatientDAO();

    @Override
    public void saveEntity(Patient patient) {
        patientDAO.saveEntity(patient);
    }

    @Override
    public Patient getEntityByID(int id) {
        return patientDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Patient patient) {
        patientDAO.updateEntity(patient);
    }

    @Override
    public void removeEntityByID(int id) {
        patientDAO.removeEntityByID(id);
    }

    @Override
    public List<Patient> getAll() {
        return patientDAO.getAll();
    }

    @Override
    public List<Patient> getPatientByPhysicianID(int physicianID) {
        return patientDAO.getPatientByPhysicianID(physicianID);
    }
}
