package org.example.interfaces;

import org.example.models.hospital.Prescriptions;

import java.util.List;

public interface IPrescriptionsDAO extends IBaseDAO<Prescriptions> {

    List<Prescriptions> getPrescriptionByPatient(int patientID);
}
