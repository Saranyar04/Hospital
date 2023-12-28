package org.example.services;

import org.example.interfaces.IExaminationRoomDAO;
import org.example.jdbc.dao.ExaminationRoomDAO;
import org.example.models.hospital.ExaminationRoom;

import java.util.List;

public class ExaminationRoomService implements IExaminationRoomDAO {

    private final ExaminationRoomDAO examinationRoomDAO = new ExaminationRoomDAO();

    @Override
    public void saveEntity(ExaminationRoom examinationRoom) {
        examinationRoomDAO.saveEntity(examinationRoom);
    }

    @Override
    public ExaminationRoom getEntityByID(int id) {
        return examinationRoomDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(ExaminationRoom examinationRoom) {
        examinationRoomDAO.updateEntity(examinationRoom);
    }

    @Override
    public void removeEntityByID(int id) {
        examinationRoomDAO.removeEntityByID(id);
    }

    @Override
    public List<ExaminationRoom> getAll() {
        return examinationRoomDAO.getAll();
    }

    @Override
    public List<ExaminationRoom> getRoomsByType(String roomType) {
        return examinationRoomDAO.getRoomsByType(roomType);
    }
}
