package org.example.interfaces;

import org.example.models.hospital.ExaminationRoom;

import java.util.List;

public interface IExaminationRoomsDAO extends IBaseDAO<ExaminationRoom> {

    List<ExaminationRoom> getRoomsbyType(String roomType);
}
