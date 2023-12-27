package org.example.interfaces;

import org.example.models.hospital.Prescription;

import java.util.List;

public interface IPrescriptionsDAO extends IBaseDAO<Prescription> {

    List<Prescription> getPrescriptionByPatientID(int patientID);
}
