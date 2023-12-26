package org.example.services;

import org.example.interfaces.IPatientsDAO;
import org.example.jdbc.dao.PatientsDAO;
import org.example.models.persons.Patient;

import java.util.List;

public class PatientsService implements IPatientsDAO {

    private final PatientsDAO patientsDAO = new PatientsDAO();

    @Override
    public void saveEntity(Patient patients) {
        patientsDAO.saveEntity(patients);
    }

    @Override
    public Patient getEntityByID(int id) {
        return patientsDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Patient patients) {
        patientsDAO.updateEntity(patients);
    }

    @Override
    public void removeEntityByID(int id) {
        patientsDAO.removeEntityByID(id);
    }

    @Override
    public List<Patient> getAll() {
        return patientsDAO.getAll();
    }

    @Override
    public List<Patient> getPatientbyPysician(int patientID) {
        return patientsDAO.getPatientbyPysician(patientID);
    }
}
