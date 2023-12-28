package org.example.services;

import org.example.interfaces.IPositionDAO;
import org.example.jdbc.dao.PositionDAO;
import org.example.models.persons.Position;

import java.util.List;

public class PositionService implements IPositionDAO {

    private final PositionDAO positionDAO = new PositionDAO();
    @Override
    public void saveEntity(Position position) {
        positionDAO.saveEntity(position);
    }

    @Override
    public Position getEntityByID(int id) {
        return positionDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Position position) {
        positionDAO.updateEntity(position);
    }

    @Override
    public void removeEntityByID(int id) {
        positionDAO.removeEntityByID(id);
    }

    @Override
    public List<Position> getAll() {
        return positionDAO.getAll();
    }

    @Override
    public List<Position> getTopPosition(int limit) {
        return positionDAO.getTopPosition(limit);
    }
}
