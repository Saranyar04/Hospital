package org.example.services;

import org.example.interfaces.IPositionsDAO;
import org.example.jdbc.dao.PositionsDAO;
import org.example.models.persons.Positions;

import java.util.List;

public class PositionsService implements IPositionsDAO {

    private final PositionsDAO positionsDAO = new PositionsDAO();
    @Override
    public void saveEntity(Positions positions) {
        positionsDAO.saveEntity(positions);
    }

    @Override
    public Positions getEntityByID(int id) {
        return positionsDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Positions positions) {
        positionsDAO.updateEntity(positions);
    }

    @Override
    public void removeEntityByID(int id) {
        positionsDAO.removeEntityByID(id);
    }

    @Override
    public List<Positions> getAll() {
        return positionsDAO.getAll();
    }

    @Override
    public List<Positions> getTopThree() {
        return positionsDAO.getTopThree();
    }
}
