package org.example.interfaces;

import org.example.models.persons.Positions;

import java.util.List;

public interface IPositionsDAO extends IBaseDAO<Positions>{

    List<Positions> getTopThree();
}
