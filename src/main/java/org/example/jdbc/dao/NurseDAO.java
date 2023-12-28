package org.example.jdbc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.interfaces.INurseDAO;
import org.example.models.persons.Nurse;
import org.example.util.ConnectionPool;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NurseDAO implements INurseDAO {

    private final static Logger LOGGER = (Logger) LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private final PositionDAO positionDAO = new PositionDAO();

    @Override
    public void saveEntity(Nurse nurses) {
        Connection connection = connectionPool.getConnection();
        positionDAO.saveEntity(nurses.getPosition());
        String query = "INSERT INTO nurses (first_name, last_name, position_id) VALUES ((?), (?), (?))";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nurses.getFirstName());
            statement.setString(2, nurses.getLastName());
            statement.setInt(3, nurses.getPosition().getPositionID());
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
    public Nurse getEntityByID(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM nurses WHERE nurse_id = (?)";
        Nurse nurses = new Nurse();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while(rs.next()) {
                    nurses.setNurseID(rs.getInt("nurse_id"));
                    nurses.setFirstName(rs.getString("first_name"));
                    nurses.setLastName(rs.getString("last_name"));
                    nurses.setPosition(positionDAO.getEntityByID(rs.getInt("position_id")));
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
        return nurses;
    }

    @Override
    public void updateEntity(Nurse nurses) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE nurses SET first_name = (?), last_name = (?) WHERE nurse_id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nurses.getFirstName());
            statement.setString(2, nurses.getLastName());
            statement.setInt(3, nurses.getNurseID());
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
        String query = "DELETE FROM nurses WHERE nurse_id = (?)";
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
    public List<Nurse> getAll() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM nurses";
        List<Nurse> nurseList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    Nurse nurse = new Nurse();
                    nurse.setNurseID(rs.getInt("nurse_id"));
                    nurse.setFirstName(rs.getString("first_name"));
                    nurse.setLastName(rs.getString("last_name"));
                    nurse.setPosition(positionDAO.getEntityByID(rs.getInt("position_id")));
                    nurseList.add(nurse);
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
        return nurseList;
    }

    @Override
    public List<Nurse> getNurseByPositionID(int positionID) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM nurses WHERE position_id = (?)";
        List<Nurse> nurseList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, positionID);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while(rs.next()) {
                    Nurse nurse = new Nurse();
                    nurse.setNurseID(rs.getInt("nurse_id"));
                    nurse.setFirstName(rs.getString("first_name"));
                    nurse.setLastName(rs.getString("last_name"));
                    nurse.setPosition(positionDAO.getEntityByID(rs.getInt("position_id")));
                    nurseList.add(nurse);
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
        return nurseList;
    }
    }

