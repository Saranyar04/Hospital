package org.example.jdbc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.interfaces.IPatientDAO;
import org.example.models.persons.Patient;
import org.example.util.ConnectionPool;

import java.lang.invoke.MethodHandles;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO implements IPatientDAO {

    private final static Logger LOGGER = (Logger) LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private final PhysicianDAO physicianDAO = new PhysicianDAO();

    @Override
    public void saveEntity(Patient patients) {
        Connection connection = connectionPool.getConnection();
        physicianDAO.saveEntity(patients.getPhysician());
        String query = "INSERT INTO patients (first_name, last_name, date_of_birth, address, physician_id) VALUES ((?), (?), (?), (?), (?))";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, patients.getFirstName());
            statement.setString(2, patients.getLastName());
            statement.setDate(3, (Date) patients.getDateOfBirth());
            statement.setString(4, patients.getAddress());
            statement.setInt(5, patients.getPhysician().getPhysicianID());
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
    public Patient getEntityByID(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM patients WHERE patient_id = (?)";
        Patient patients = new Patient();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while(rs.next()) {
                    patients.setPatientID(rs.getInt("patient_id"));
                    patients.setFirstName(rs.getString("first_name"));
                    patients.setLastName(rs.getString("last_name"));
                    patients.setDateOfBirth(rs.getDate("date_of_birth"));
                    patients.setAddress(rs.getString("address"));
                    patients.setPhysician(physicianDAO.getEntityByID(rs.getInt("physician_id")));
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
        return patients;
    }

    @Override
    public void updateEntity(Patient patients) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE patients SET first_name = (?), last_name = (?) WHERE patient_id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, patients.getFirstName());
            statement.setString(2, patients.getLastName());
            statement.setInt(3, patients.getPatientID());
            statement.executeUpdate();
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
        String query = "DELETE FROM patients WHERE patient_id = (?)";
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
    public List<Patient> getAll() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM patients";
        List<Patient> patientsList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    Patient patients = new Patient();
                    patients.setPatientID(rs.getInt("patients_id"));
                    patients.setFirstName(rs.getString("first_name"));
                    patients.setLastName(rs.getString("last_name"));
                    patients.setPhysician(physicianDAO.getEntityByID(rs.getInt("physician_id")));
                    patientsList.add(patients);
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
        return patientsList;
    }

    @Override
    public List<Patient> getPatientByPhysicianID(int physicianID) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM patients WHERE physician_id = (?)";
        List<Patient> patientsList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, physicianID);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    Patient patients = new Patient();
                    patients.setPatientID(rs.getInt("patients_id"));
                    patients.setFirstName(rs.getString("first_name"));
                    patients.setLastName(rs.getString("last_name"));
                    patients.setPhysician(physicianDAO.getEntityByID(rs.getInt("physician_id")));
                    patientsList.add(patients);
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
        return patientsList;
    }
}
