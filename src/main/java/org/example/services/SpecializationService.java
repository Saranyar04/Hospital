package org.example.services;

import org.example.interfaces.ISpecializationsDAO;
import org.example.jdbc.dao.SpecializationsDAO;
import org.example.models.persons.Specialization;

import java.util.List;

public class SpecializationsService implements ISpecializationsDAO {

    private final SpecializationsDAO specializationsDAO = new SpecializationsDAO();

    @Override
    public void saveEntity(Specialization specialization) {
        specializationsDAO.saveEntity(specialization);
    }

    @Override
    public Specialization getEntityByID(int id) {
        return specializationsDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Specialization specialization) {
        specializationsDAO.updateEntity(specialization);
    }

    @Override
    public void removeEntityByID(int id) {
        specializationsDAO.removeEntityByID(id);
    }

    @Override
    public List<Specialization> getAll() {
        return specializationsDAO.getAll();
    }

    @Override
    public int getCountOfSpecialization() {
        return specializationsDAO.getCountOfSpecialization();
    }
}