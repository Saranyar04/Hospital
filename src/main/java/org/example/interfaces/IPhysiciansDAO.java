package org.example.interfaces;

import org.example.models.persons.Physicians;

import java.util.List;

public interface IPhysiciansDAO extends IBaseDAO<Physicians> {

    String getAddressByID(int departmentID);
}
