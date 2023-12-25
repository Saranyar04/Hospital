package org.example.services;

import org.example.interfaces.ISpecializationsDAO;
import org.example.jdbc.dao.SpecializationsDAO;
import org.example.models.persons.Specializations;

import java.util.List;

public class SpecializationsService implements ISpecializationsDAO {

    private final SpecializationsDAO specializationsDAO = new SpecializationsDAO();

    @Override
    public void saveEntity(Specializations specializations) {
        specializationsDAO.saveEntity(specializations);
    }

    @Override
    public Specializations getEntityByID(int id) {
        return specializationsDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Specializations specializations) {
        specializationsDAO.updateEntity(specializations);
    }

    @Override
    public void removeEntityByID(int id) {
        specializationsDAO.removeEntityByID(id);
    }

    @Override
    public List<Specializations> getAll() {
        return specializationsDAO.getAll();
    }

    @Override
    public int getCountOfSpecialization() {
        return specializationsDAO.getCountOfSpecialization();
    }
}
