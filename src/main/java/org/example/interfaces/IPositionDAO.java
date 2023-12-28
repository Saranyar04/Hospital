package org.example.interfaces;

import org.example.models.persons.Position;

import java.util.List;

public interface IPositionDAO extends IBaseDAO<Position>{

    List<Position> getTopPosition(int limit);
}
