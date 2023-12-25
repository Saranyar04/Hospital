package org.example.interfaces;

import org.example.models.persons.Nurses;

import java.util.List;

public interface INursesDAO extends IBaseDAO<Nurses>{

    List<Nurses> getNurseByPositions(int positionID);
}
