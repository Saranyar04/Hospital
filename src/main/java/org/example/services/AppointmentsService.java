package org.example.services;

import org.example.interfaces.IAppointmentDAO;
import org.example.jdbc.dao.AppointmentsDAO;
import org.example.models.hospital.Appointment;

import java.util.List;

public class AppointmentsService implements IAppointmentDAO {

    private final AppointmentsDAO appointmentsDAO = new AppointmentsDAO();

    @Override
    public List<Appointment> getAppointmentByPhysicianID(int id) {
        return appointmentsDAO.getAppointmentByPhysicianID(id);
    }

    @Override
    public void saveEntity(Appointment appointment) {
        appointmentsDAO.saveEntity(appointment);
    }

    @Override
    public Appointment getEntityByID(int id) {
        return appointmentsDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Appointment appointment) {
        appointmentsDAO.updateEntity(appointment);
    }

    @Override
    public void removeEntityByID(int id) {
        appointmentsDAO.removeEntityByID(id);
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentsDAO.getAll();
    }
}
