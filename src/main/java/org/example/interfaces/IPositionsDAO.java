package org.example.interfaces;

import org.example.models.persons.Position;

import java.util.List;

public interface IPositionsDAO extends IBaseDAO<Position>{

    List<Position> getTopPosition(int limit);
}
