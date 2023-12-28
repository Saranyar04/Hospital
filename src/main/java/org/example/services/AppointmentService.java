package org.example.services;

import org.example.interfaces.IAppointmentDAO;
import org.example.jdbc.dao.AppointmentDAO;
import org.example.models.hospital.Appointment;

import java.util.List;

public class AppointmentService implements IAppointmentDAO {

    private final AppointmentDAO appointmentDAO = new AppointmentDAO();

    @Override
    public List<Appointment> getAppointmentByPhysicianID(int id) {
        return appointmentDAO.getAppointmentByPhysicianID(id);
    }

    @Override
    public void saveEntity(Appointment appointment) {
        appointmentDAO.saveEntity(appointment);
    }

    @Override
    public Appointment getEntityByID(int id) {
        return appointmentDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Appointment appointment) {
        appointmentDAO.updateEntity(appointment);
    }

    @Override
    public void removeEntityByID(int id) {
        appointmentDAO.removeEntityByID(id);
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentDAO.getAll();
    }
}
