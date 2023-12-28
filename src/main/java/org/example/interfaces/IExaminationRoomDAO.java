package org.example.interfaces;

import org.example.models.hospital.ExaminationRoom;

import java.util.List;

public interface IExaminationRoomDAO extends IBaseDAO<ExaminationRoom> {

    List<ExaminationRoom> getRoomsByType(String roomType);
}
