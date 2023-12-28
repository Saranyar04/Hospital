package org.example.services;

import org.example.interfaces.IPositionsDAO;
import org.example.jdbc.dao.PositionsDAO;
import org.example.models.persons.Position;

import java.util.List;

public class PositionsService implements IPositionsDAO {

    private final PositionsDAO positionsDAO = new PositionsDAO();
    @Override
    public void saveEntity(Position position) {
        positionsDAO.saveEntity(position);
    }

    @Override
    public Position getEntityByID(int id) {
        return positionsDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Position position) {
        positionsDAO.updateEntity(position);
    }

    @Override
    public void removeEntityByID(int id) {
        positionsDAO.removeEntityByID(id);
    }

    @Override
    public List<Position> getAll() {
        return positionsDAO.getAll();
    }

    @Override
    public List<Position> getTopPosition(int limit) {
        return positionsDAO.getTopPosition(limit);
    }
}
