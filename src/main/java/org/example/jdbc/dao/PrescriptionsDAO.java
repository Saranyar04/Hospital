package org.example.jdbc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.models.hospital.Prescription;
import org.example.interfaces.IPrescriptionsDAO;
import org.example.util.ConnectionPool;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionsDAO implements IPrescriptionsDAO {

    private final static Logger LOGGER = (Logger) LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private final PhysiciansDAO physiciansDAO = new PhysiciansDAO();
    private final PatientsDAO patientsDAO = new PatientsDAO();
    private final MedicationsDAO medicationsDAO = new MedicationsDAO();

    @Override
    public void saveEntity(Prescription prescriptions) {
        Connection connection = connectionPool.getConnection();
        physiciansDAO.saveEntity(prescriptions.getPhysicians());
        patientsDAO.saveEntity(prescriptions.getPatients());
        medicationsDAO.saveEntity(prescriptions.getMedications());
        String query = "INSERT INTO prescription (date, physician_id, patient_id, medication_id) VALUES ((?), (?), (?), (?))";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDate(1, prescriptions.getDate());
            statement.setInt(2, prescriptions.getPhysicians().getPhysicianID());
            statement.setInt(3, prescriptions.getPatients().getPatientID());
            statement.setInt(4, prescriptions.getMedications().getMedicationID());
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
    public Prescription getEntityByID(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM prescriptions WHERE prescription_id = (?)";
        Prescription prescriptions = new Prescription();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while(rs.next()) {
                    prescriptions.setPrescriptionID(rs.getInt("prescription_id"));
                    prescriptions.setDate(rs.getDate("date"));
                    prescriptions.setPhysicians(physiciansDAO.getEntityByID(rs.getInt("physician_id")));
                    prescriptions.setPatients(patientsDAO.getEntityByID(rs.getInt("patient_id")));
                    prescriptions.setMedications(medicationsDAO.getEntityByID(rs.getInt("medication_id")));
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
        return prescriptions;
    }

    @Override
    public void updateEntity(Prescription prescriptions) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE prescriptions SET medication_id = (?) WHERE prescription_id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, prescriptions.getMedications().getMedicationID());
            statement.setInt(2, prescriptions.getPrescriptionID());
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
        String query = "DELETE FROM prescriptions WHERE prescription_id = (?)";
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
    public List<Prescription> getAll() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM prescriptions";
        List<Prescription> prescriptionsList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    Prescription prescriptions = new Prescription();
                    prescriptions.setPrescriptionID(rs.getInt("prescription_id"));
                    prescriptions.setDate(rs.getDate("date"));
                    prescriptions.setPhysicians(physiciansDAO.getEntityByID(rs.getInt("physician_id")));
                    prescriptions.setPatients(patientsDAO.getEntityByID(rs.getInt("patient_id")));
                    prescriptions.setMedications(medicationsDAO.getEntityByID(rs.getInt("medication_id")));
                    prescriptionsList.add(prescriptions);
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
        return prescriptionsList;
    }

    @Override
    public List<Prescription> getPrescriptionByPatient(int patientID) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM prescriptions WHERE patient_id = (?)";
        List<Prescription> prescriptionsList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, patientID);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    Prescription prescriptions = new Prescription();
                    prescriptions.setPrescriptionID(rs.getInt("prescription_id"));
                    prescriptions.setDate(rs.getDate("date"));
                    prescriptions.setPhysicians(physiciansDAO.getEntityByID(rs.getInt("physician_id")));
                    prescriptions.setPatients(patientsDAO.getEntityByID(rs.getInt("patient_id")));
                    prescriptions.setMedications(medicationsDAO.getEntityByID(rs.getInt("medication_id")));
                    prescriptionsList.add(prescriptions);
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
        return prescriptionsList;
    }
}
