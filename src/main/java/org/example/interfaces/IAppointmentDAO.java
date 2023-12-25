package org.example.interfaces;

import org.example.models.hospital.Appointments;

import java.util.List;

public interface IAppointmentDAO extends IBaseDAO<Appointments> {

    List<Appointments> getAppointmentByPhysician(int id);
}
