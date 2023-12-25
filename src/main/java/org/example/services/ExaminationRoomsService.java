package org.example.services;

import org.example.interfaces.IExaminationRoomsDAO;
import org.example.jdbc.dao.ExaminationRoomsDAO;
import org.example.models.hospital.ExaminationRooms;

import java.util.List;

public class ExaminationRoomsService implements IExaminationRoomsDAO {

    private final ExaminationRoomsDAO examinationRoomsDAO = new ExaminationRoomsDAO();

    @Override
    public void saveEntity(ExaminationRooms examinationRooms) {
        examinationRoomsDAO.saveEntity(examinationRooms);
    }

    @Override
    public ExaminationRooms getEntityByID(int id) {
        return examinationRoomsDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(ExaminationRooms examinationRooms) {
        examinationRoomsDAO.updateEntity(examinationRooms);
    }

    @Override
    public void removeEntityByID(int id) {
        examinationRoomsDAO.removeEntityByID(4);
    }

    @Override
    public List<ExaminationRooms> getAll() {
        return examinationRoomsDAO.getAll();
    }

    @Override
    public List<ExaminationRooms> getRoomsbyType(String roomType) {
        return examinationRoomsDAO.getRoomsbyType(roomType);
    }
}
