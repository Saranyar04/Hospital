package org.example.services;

import org.example.interfaces.IAppointmentDAO;
import org.example.jdbc.dao.AppointmentsDAO;
import org.example.models.hospital.Appointments;

import java.util.List;

public class AppointmentsService implements IAppointmentDAO {

    private final AppointmentsDAO appointmentsDAO = new AppointmentsDAO();

    @Override
    public List<Appointments> getAppointmentByPhysician(int id) {
        return appointmentsDAO.getAppointmentByPhysician(id);
    }

    @Override
    public void saveEntity(Appointments appointments) {
        appointmentsDAO.saveEntity(appointments);
    }

    @Override
    public Appointments getEntityByID(int id) {
        return appointmentsDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Appointments appointments) {
        appointmentsDAO.updateEntity(appointments);
    }

    @Override
    public void removeEntityByID(int id) {
        appointmentsDAO.removeEntityByID(id);
    }

    @Override
    public List<Appointments> getAll() {
        return appointmentsDAO.getAll();
    }
}
