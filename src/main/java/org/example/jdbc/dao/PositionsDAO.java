package org.example.jdbc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.interfaces.IPositionsDAO;
import org.example.models.persons.Position;
import org.example.util.ConnectionPool;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionsDAO implements IPositionsDAO {

    private final static Logger LOGGER = (Logger) LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void saveEntity(Position positions) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO positions (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, positions.getName());
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
    public Position getEntityByID(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM positions WHERE position_id = (?)";
        Position position = new Position();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while(rs.next()) {
                    position.setPositionID(rs.getInt("position_id"));
                    position.setName(rs.getString("name"));
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
        return position;
    }

    @Override
    public void updateEntity(Position positions) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE positions SET name = (?) WHERE position_id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, positions.getName());
            statement.setInt(2, positions.getPositionID());
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
        String query = "DELETE FROM positions WHERE position_id = (?)";
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
    public List<Position> getAll() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM positions";
        List<Position> positionsList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    Position positions = new Position();
                    positions.setPositionID(rs.getInt("position_id"));
                    positions.setName(rs.getString("name"));
                    positionsList.add(positions);
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
        return positionsList;
    }

    @Override
    public List<Position> getTopThree() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM positions LIMIT 3";
        List<Position> positionsList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    Position positions = new Position();
                    positions.setPositionID(rs.getInt("position_id"));
                    positions.setName(rs.getString("name"));
                    positionsList.add(positions);
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
        return positionsList;
    }
}
