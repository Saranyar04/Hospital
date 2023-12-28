package org.example.interfaces;

import org.example.models.persons.Physician;

public interface IPhysicianDAO extends IBaseDAO<Physician> {

    String getAddressByID(int departmentID);
}
