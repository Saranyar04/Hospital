package org.example.interfaces;

import org.example.models.persons.Nurse;

import java.util.List;

public interface INurseDAO extends IBaseDAO<Nurse>{

    List<Nurse> getNurseByPositionID(int positionID);
}
