package org.example.services;

import org.example.interfaces.IExaminationRoomsDAO;
import org.example.jdbc.dao.ExaminationRoomsDAO;
import org.example.models.hospital.ExaminationRoom;

import java.util.List;

public class ExaminationRoomsService implements IExaminationRoomsDAO {

    private final ExaminationRoomsDAO examinationRoomsDAO = new ExaminationRoomsDAO();

    @Override
    public void saveEntity(ExaminationRoom examinationRooms) {
        examinationRoomsDAO.saveEntity(examinationRooms);
    }

    @Override
    public ExaminationRoom getEntityByID(int id) {
        return examinationRoomsDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(ExaminationRoom examinationRooms) {
        examinationRoomsDAO.updateEntity(examinationRooms);
    }

    @Override
    public void removeEntityByID(int id) {
        examinationRoomsDAO.removeEntityByID(id);
    }

    @Override
    public List<ExaminationRoom> getAll() {
        return examinationRoomsDAO.getAll();
    }

    @Override
    public List<ExaminationRoom> getRoomsbyType(String roomType) {
        return examinationRoomsDAO.getRoomsbyType(roomType);
    }
}
