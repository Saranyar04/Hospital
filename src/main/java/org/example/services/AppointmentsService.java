package org.example.services;

import org.example.interfaces.IAppointmentDAO;
import org.example.jdbc.dao.AppointmentsDAO;
import org.example.models.hospital.Appointment;

import java.util.List;

public class AppointmentsService implements IAppointmentDAO {

    private final AppointmentsDAO appointmentsDAO = new AppointmentsDAO();

    @Override
    public List<Appointment> getAppointmentByPhysician(int id) {
        return appointmentsDAO.getAppointmentByPhysician(id);
    }

    @Override
    public void saveEntity(Appointment appointments) {
        appointmentsDAO.saveEntity(appointments);
    }

    @Override
    public Appointment getEntityByID(int id) {
        return appointmentsDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Appointment appointments) {
        appointmentsDAO.updateEntity(appointments);
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
