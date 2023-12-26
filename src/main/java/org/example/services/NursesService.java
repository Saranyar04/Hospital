package org.example.services;

import org.example.interfaces.INursesDAO;
import org.example.jdbc.dao.NursesDAO;
import org.example.models.persons.Nurses;

import java.util.List;

public class NursesService implements INursesDAO {

    private final NursesDAO nursesDAO = new NursesDAO();

    @Override
    public void saveEntity(Nurses nurses) {
        nursesDAO.saveEntity(nurses);
    }

    @Override
    public Nurses getEntityByID(int id) {
        return nursesDAO.getEntityByID(5);
    }

    @Override
    public void updateEntity(Nurses nurses) {
        nursesDAO.updateEntity(nurses);
    }

    @Override
    public void removeEntityByID(int id) {
        nursesDAO.removeEntityByID(5);
    }

    @Override
    public List<Nurses> getAll() {
        return nursesDAO.getAll();
    }

    @Override
    public List<Nurses> getNurseByPositions(int positionID) {
        return nursesDAO.getNurseByPositions(5);
    }
}
