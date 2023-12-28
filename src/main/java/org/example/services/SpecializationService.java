package org.example.services;

import org.example.interfaces.ISpecializationDAO;
import org.example.jdbc.dao.SpecializationDAO;
import org.example.models.persons.Specialization;

import java.util.List;

public class SpecializationService implements ISpecializationDAO {

    private final SpecializationDAO specializationDAO = new SpecializationDAO();

    @Override
    public void saveEntity(Specialization specialization) {
        specializationDAO.saveEntity(specialization);
    }

    @Override
    public Specialization getEntityByID(int id) {
        return specializationDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Specialization specialization) {
        specializationDAO.updateEntity(specialization);
    }

    @Override
    public void removeEntityByID(int id) {
        specializationDAO.removeEntityByID(id);
    }

    @Override
    public List<Specialization> getAll() {
        return specializationDAO.getAll();
    }

    @Override
    public int getCountOfSpecialization() {
        return specializationDAO.getCountOfSpecialization();
    }
}
