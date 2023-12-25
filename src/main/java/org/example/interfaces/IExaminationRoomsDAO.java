package org.example.interfaces;

import org.example.models.hospital.ExaminationRooms;

import java.util.List;

public interface IExaminationRoomsDAO extends IBaseDAO<ExaminationRooms> {

    List<ExaminationRooms> getRoomsbyType(String roomType);
}
