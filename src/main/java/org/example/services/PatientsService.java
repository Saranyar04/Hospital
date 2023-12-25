package org.example.services;

import org.example.interfaces.IPatientsDAO;
import org.example.jdbc.dao.PatientsDAO;
import org.example.models.persons.Patients;

import java.util.List;

public class PatientsService implements IPatientsDAO {

    private final PatientsDAO patientsDAO = new PatientsDAO();

    @Override
    public void saveEntity(Patients patients) {
        patientsDAO.saveEntity(patients);
    }

    @Override
    public Patients getEntityByID(int id) {
        return patientsDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Patients patients) {
        patientsDAO.updateEntity(patients);
    }

    @Override
    public void removeEntityByID(int id) {
        patientsDAO.removeEntityByID(id);
    }

    @Override
    public List<Patients> getAll() {
        return patientsDAO.getAll();
    }

    @Override
    public List<Patients> getPatientbyPysician(int patientID) {
        return patientsDAO.getPatientbyPysician(patientID);
    }
}
