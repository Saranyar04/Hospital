package org.example.interfaces;

import org.example.models.persons.Patient;

import java.util.List;

public interface IPatientsDAO extends IBaseDAO<Patient> {

    List<Patient> getPatientbyPysician(int patientID);
}
