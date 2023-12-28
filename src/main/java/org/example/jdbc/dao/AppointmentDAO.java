package org.example.jdbc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.models.hospital.Appointment;
import org.example.interfaces.IAppointmentDAO;
import org.example.util.ConnectionPool;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO implements IAppointmentDAO {

    private final static Logger LOGGER = (Logger) LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private final PatientDAO patientDAO = new PatientDAO();
    private final PhysicianDAO physicianDAO = new PhysicianDAO();
    private final NurseDAO nurseDAO = new NurseDAO();
    private final ExaminationRoomDAO examinationRoomDAO = new ExaminationRoomDAO();
    private final ProcedureDAO procedureDAO = new ProcedureDAO();

    @Override
    public List<Appointment> getAppointmentByPhysicianID(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM appointments WHERE physician_id = (?)";
        List<Appointment> appointmentList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    Appointment appointments = new Appointment();
                    appointments.setAppointmentID(rs.getInt("appointment_id"));
                    appointments.setStartTime(rs.getString("start_time"));
                    appointments.setEndTime(rs.getString("end_time"));
                    appointments.setPatient(patientDAO.getEntityByID(rs.getInt("patient_id")));
                    appointments.setPhysician(physicianDAO.getEntityByID(rs.getInt("physician_id")));
                    appointments.setNurse(nurseDAO.getEntityByID(rs.getInt("nurse_id")));
                    appointments.setExaminationRoom(examinationRoomDAO.getEntityByID(rs.getInt("examination_room_no")));
                    appointments.setProcedure(procedureDAO.getEntityByID(rs.getInt("procedure_id")));
                    appointmentList.add(appointments);
                }
            }
        } catch(SQLException e){
            LOGGER.error(e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info(e);
                }
            }
        }
        return appointmentList;
    }

    @Override
    public void saveEntity(Appointment appointments) {
        Connection connection = connectionPool.getConnection();
        patientDAO.saveEntity(appointments.getPatient());
        physicianDAO.saveEntity(appointments.getPhysician());
        nurseDAO.saveEntity(appointments.getNurse());
        examinationRoomDAO.saveEntity(appointments.getExaminationRoom());
        String query = "INSERT INTO (start_time, end_time, patient_id, physician_id, nurse_id, examination_room_no, procedure_id) VALUES ('?', '?', '?', '?', '?', '?', '?')";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, appointments.getStartTime());
            statement.setString(2, appointments.getEndTime());
            statement.setInt(3, appointments.getPatient().getPatientID());
            statement.setInt(4, appointments.getPhysician().getPhysicianID());
            statement.setInt(5, appointments.getNurse().getNurseID());
            statement.setInt(6, appointments.getExaminationRoom().getExaminationRoomNo());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info(e);
                }
            }
        }
    }

    @Override
    public Appointment getEntityByID(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM appointments WHERE appointment_id = (?)";
        Appointment appointments = new Appointment();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while(rs.next()) {
                    appointments.setAppointmentID(rs.getInt("appointment_id"));
                    appointments.setStartTime(rs.getString("start_time"));
                    appointments.setEndTime(rs.getString("end_time"));
                    appointments.setPatient(patientDAO.getEntityByID(rs.getInt("patient_id")));
                    appointments.setPhysician(physicianDAO.getEntityByID(rs.getInt("physician_id")));
                    appointments.setNurse(nurseDAO.getEntityByID(rs.getInt("nurse_id")));
                    appointments.setExaminationRoom(examinationRoomDAO.getEntityByID(rs.getInt("examination_room_no")));
                    appointments.setProcedure(procedureDAO.getEntityByID(rs.getInt("procedure_id")));
                }
            }
        } catch(SQLException e){
            LOGGER.error(e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info(e);
                }
            }
        }
        return appointments;
    }

    @Override
    public void updateEntity(Appointment appointments) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE appointments SET start_time = (?), end_time = (?), patient_id = (?), physician_id = (?), nurse_id = (?), examination_room_no = (?), procedure_id = (?) WHERE appointment_id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, appointments.getStartTime());
            statement.setString(2, appointments.getStartTime());
            statement.setInt(3, appointments.getPatient().getPatientID());
            statement.setInt(4, appointments.getPhysician().getPhysicianID());
            statement.setInt(5, appointments.getNurse().getNurseID());
            statement.setInt(6, appointments.getExaminationRoom().getExaminationRoomNo());
            statement.setInt(6, appointments.getProcedure().getProcedureID());
        } catch(SQLException e){
            LOGGER.error(e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info(e);
                }
            }
        }
    }

    @Override
    public void removeEntityByID(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "DELETE FROM appointments WHERE appoinment_id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();

        } catch(SQLException e){
            LOGGER.error(e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info(e);
                }
            }
        }
    }

    @Override
    public List<Appointment> getAll() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM appointments";
        List<Appointment> appointmentList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    Appointment appointments = new Appointment();
                    appointments.setAppointmentID(rs.getInt("appointment_id"));
                    appointments.setStartTime(rs.getString("start_time"));
                    appointments.setEndTime(rs.getString("end_time"));
                    appointments.setPatient(patientDAO.getEntityByID(rs.getInt("patient_id")));
                    appointments.setPhysician(physicianDAO.getEntityByID(rs.getInt("physician_id")));
                    appointments.setNurse(nurseDAO.getEntityByID(rs.getInt("nurse_id")));
                    appointments.setExaminationRoom(examinationRoomDAO.getEntityByID(rs.getInt("examination_room_no")));
                    appointments.setProcedure(procedureDAO.getEntityByID(rs.getInt("procedure_id")));
                    appointmentList.add(appointments);
                }
            }
        } catch(SQLException e){
            LOGGER.error(e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.info(e);
                }
            }
        }
        return appointmentList;
    }
}