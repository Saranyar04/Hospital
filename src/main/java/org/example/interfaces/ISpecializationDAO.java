package org.example.interfaces;

import org.example.models.persons.Specialization;

public interface ISpecializationDAO extends IBaseDAO<Specialization> {

    int getCountOfSpecialization();
}
