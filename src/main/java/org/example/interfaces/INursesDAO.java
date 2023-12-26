package org.example.interfaces;

import org.example.models.persons.Nurse;

import java.util.List;

public interface INursesDAO extends IBaseDAO<Nurse>{

    List<Nurse> getNurseByPositions(int positionID);
}
