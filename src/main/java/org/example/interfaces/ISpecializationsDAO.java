package org.example.interfaces;

import org.example.models.persons.Specializations;

public interface ISpecializationsDAO extends IBaseDAO<Specializations> {

    int getCountOfSpecialization();
}
