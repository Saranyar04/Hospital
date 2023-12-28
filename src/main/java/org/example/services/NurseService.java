package org.example.services;

import org.example.interfaces.INurseDAO;
import org.example.jdbc.dao.NurseDAO;
import org.example.models.persons.Nurse;

import java.util.List;

public class NurseService implements INurseDAO {

    private final NurseDAO nurseDAO = new NurseDAO();

    @Override
    public void saveEntity(Nurse nurse) {
        nurseDAO.saveEntity(nurse);
    }

    @Override
    public Nurse getEntityByID(int id) {
        return nurseDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Nurse nurse) {
        nurseDAO.updateEntity(nurse);
    }

    @Override
    public void removeEntityByID(int id) {
        nurseDAO.removeEntityByID(id);
    }

    @Override
    public List<Nurse> getAll() {
        return nurseDAO.getAll();
    }

    @Override
    public List<Nurse> getNurseByPositionID(int positionID) {
        return nurseDAO.getNurseByPositionID(positionID);
    }
}
