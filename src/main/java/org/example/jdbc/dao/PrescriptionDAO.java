package org.example.jdbc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.models.hospital.Prescription;
import org.example.interfaces.IPrescriptionDAO;
import org.example.util.ConnectionPool;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionDAO implements IPrescriptionDAO {

    private final static Logger LOGGER = (Logger) LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private final PhysicianDAO physicianDAO = new PhysicianDAO();
    private final PatientDAO patientDAO = new PatientDAO();
    private final MedicationDAO medicationDAO = new MedicationDAO();

    @Override
    public void saveEntity(Prescription prescriptions) {
        Connection connection = connectionPool.getConnection();
        physicianDAO.saveEntity(prescriptions.getPhysician());
        patientDAO.saveEntity(prescriptions.getPatient());
        medicationDAO.saveEntity(prescriptions.getMedication());
        String query = "INSERT INTO prescription (date, physician_id, patient_id, medication_id) VALUES ((?), (?), (?), (?))";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDate(1, prescriptions.getDate());
            statement.setInt(2, prescriptions.getPhysician().getPhysicianID());
            statement.setInt(3, prescriptions.getPatient().getPatientID());
            statement.setInt(4, prescriptions.getMedication().getMedicationID());
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
                    prescriptions.setPhysician(physicianDAO.getEntityByID(rs.getInt("physician_id")));
                    prescriptions.setPatient(patientDAO.getEntityByID(rs.getInt("patient_id")));
                    prescriptions.setMedication(medicationDAO.getEntityByID(rs.getInt("medication_id")));
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
            statement.setInt(1, prescriptions.getMedication().getMedicationID());
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
                    prescriptions.setPhysician(physicianDAO.getEntityByID(rs.getInt("physician_id")));
                    prescriptions.setPatient(patientDAO.getEntityByID(rs.getInt("patient_id")));
                    prescriptions.setMedication(medicationDAO.getEntityByID(rs.getInt("medication_id")));
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
    public List<Prescription> getPrescriptionByPatientID(int patientID) {
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
                    prescriptions.setPhysician(physicianDAO.getEntityByID(rs.getInt("physician_id")));
                    prescriptions.setPatient(patientDAO.getEntityByID(rs.getInt("patient_id")));
                    prescriptions.setMedication(medicationDAO.getEntityByID(rs.getInt("medication_id")));
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
