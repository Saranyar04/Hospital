package org.example.services;

import org.example.interfaces.INursesDAO;
import org.example.jdbc.dao.NursesDAO;
import org.example.models.persons.Nurse;

import java.util.List;

public class NursesService implements INursesDAO {

    private final NursesDAO nursesDAO = new NursesDAO();

    @Override
    public void saveEntity(Nurse nurses) {
        nursesDAO.saveEntity(nurses);
    }

    @Override
    public Nurse getEntityByID(int id) {
        return nursesDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Nurse nurses) {
        nursesDAO.updateEntity(nurses);
    }

    @Override
    public void removeEntityByID(int id) {
        nursesDAO.removeEntityByID(id);
    }

    @Override
    public List<Nurse> getAll() {
        return nursesDAO.getAll();
    }

    @Override
    public List<Nurse> getNurseByPositions(int positionID) {
        return nursesDAO.getNurseByPositions(positionID);
    }
}
