package org.example.interfaces;

import org.example.models.hospital.Appointment;

import java.util.List;

public interface IAppointmentDAO extends IBaseDAO<Appointment> {

    List<Appointment> getAppointmentByPhysicianID(int id);
}
