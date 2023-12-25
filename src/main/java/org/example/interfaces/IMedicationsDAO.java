package org.example.interfaces;

import org.example.models.hospital.Medications;

import java.util.List;

public interface IMedicationsDAO extends IBaseDAO<Medications>{

    List<Medications> getMedicationsByManufacturer(int manufacturerID);
}
