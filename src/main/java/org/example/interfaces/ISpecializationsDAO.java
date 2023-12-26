package org.example.interfaces;

import org.example.models.persons.Specialization;

public interface ISpecializationsDAO extends IBaseDAO<Specialization> {

    int getCountOfSpecialization();
}
