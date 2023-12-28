package org.example.interfaces;

import org.example.models.hospital.Medication;

import java.util.List;

public interface IMedicationDAO extends IBaseDAO<Medication>{

    List<Medication> getMedicationsByManufacturerID(int manufacturerID);
}
