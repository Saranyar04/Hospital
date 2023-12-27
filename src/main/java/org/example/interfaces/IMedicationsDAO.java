package org.example.interfaces;

import org.example.models.hospital.Medication;

import java.util.List;

public interface IMedicationsDAO extends IBaseDAO<Medication>{

    List<Medication> getMedicationsByManufacturerID(int manufacturerID);
}
