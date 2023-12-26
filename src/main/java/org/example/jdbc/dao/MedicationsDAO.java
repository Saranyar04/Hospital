package org.example.jdbc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.models.hospital.Medication;
import org.example.interfaces.IMedicationsDAO;
import org.example.util.ConnectionPool;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicationsDAO implements IMedicationsDAO {

    private final static Logger LOGGER = (Logger) LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private final ManufacturersDAO manufacturersDAO = new ManufacturersDAO();

    @Override
    public void saveEntity(Medication medications) {
        Connection connection = connectionPool.getConnection();
        manufacturersDAO.saveEntity(medications.getManufacturers());
        String query = "INSERT INTO manufacturers (medication_name, details, amount, manufacturer_id) VALUES ((?), (?), (?), (?))";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, medications.getMedicationName());
            statement.setString(2, medications.getDetails());
            statement.setDouble(3, medications.getAmount());
            statement.setInt(4, medications.getManufacturers().getManufacturerID());
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
    public Medication getEntityByID(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM medications WHERE medication_id = (?)";
        Medication medications = new Medication();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while(rs.next()) {
                    medications.setMedicationID(rs.getInt("medication_id"));
                    medications.setMedicationName(rs.getString("medication_name"));
                    medications.setDetails(rs.getString("details"));
                    medications.setAmount(rs.getDouble("amount"));
                    medications.setManufacturers(manufacturersDAO.getEntityByID(rs.getInt("manufacturer_id")));
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
        return medications;
    }

    @Override
    public void updateEntity(Medication medications) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE medications SET medication_name = (?), details = (?), amount = (?), manufacturer_id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, medications.getMedicationName());
            statement.setString(2, medications.getDetails());
            statement.setDouble(3, medications.getAmount());
            statement.setInt(4, medications.getManufacturers().getManufacturerID());
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
        String query = "DELETE FROM medications WHERE medication_id = (?)";
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
    public List<Medication> getAll() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM medications";
        List<Medication> medicationsList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    Medication medications = new Medication();
                    medications.setMedicationID(rs.getInt("medication_id"));
                    medications.setMedicationName(rs.getString("medication_name"));
                    medications.setDetails(rs.getString("details"));
                    medications.setAmount(rs.getDouble("amount"));
                    medications.setManufacturers(manufacturersDAO.getEntityByID(rs.getInt("manufacturer_id")));
                    medicationsList.add(medications);
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
        return medicationsList;
    }

    @Override
    public List<Medication> getMedicationsByManufacturer(int manufacturerID) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM medications WHERE medication_id = (?)";
        List<Medication> medicationsList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, manufacturerID);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while(rs.next()) {
                    Medication medications = new Medication();
                    medications.setMedicationID(rs.getInt("medication_id"));
                    medications.setMedicationName(rs.getString("medication_name"));
                    medications.setDetails(rs.getString("details"));
                    medications.setAmount(rs.getDouble("amount"));
                    medications.setManufacturers(manufacturersDAO.getEntityByID(rs.getInt("manufacturer_id")));
                    medicationsList.add(medications);
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
        return medicationsList;
    }
}
