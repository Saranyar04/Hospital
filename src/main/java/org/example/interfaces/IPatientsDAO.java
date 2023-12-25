package org.example.interfaces;

import org.example.models.persons.Patients;

import java.util.List;

public interface IPatientsDAO extends IBaseDAO<Patients> {

    List<Patients> getPatientbyPysician(int patientID);
}
