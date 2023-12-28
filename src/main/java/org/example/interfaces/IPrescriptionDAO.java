package org.example.interfaces;

import org.example.models.hospital.Prescription;

import java.util.List;

public interface IPrescriptionDAO extends IBaseDAO<Prescription> {

    List<Prescription> getPrescriptionByPatientID(int patientID);
}
