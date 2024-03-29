package org.example.jdbc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.interfaces.ISpecializationDAO;
import org.example.models.persons.Specialization;
import org.example.util.ConnectionPool;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecializationDAO implements ISpecializationDAO {

    private final static Logger LOGGER = (Logger) LogManager.getLogger(MethodHandles.lookup( ).lookupClass( ));
    private final ConnectionPool connectionPool = ConnectionPool.getInstance( );

    @Override
    public void saveEntity(Specialization specializations) {
        Connection connection = connectionPool.getConnection( );
        String query = "INSERT INTO specializations (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, specializations.getName( ));
            statement.executeUpdate( );
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
    public Specialization getEntityByID(int id) {
        Connection connection = connectionPool.getConnection( );
        String query = "SELECT * FROM specializations WHERE specialization_id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
            try (ResultSet rs = statement.getResultSet( )) {
                while (rs.next()) {
                    return new Specialization(rs.getInt("specialization_id"), rs.getString("name"));
                }
            }
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
        return null;
    }

    @Override
    public void updateEntity(Specialization specializations) {
        Connection connection = connectionPool.getConnection( );
        String query = "UPDATE specializations SET name = (?) WHERE specialization_id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, specializations.getName( ));
            statement.setInt(2, specializations.getSpecializationID( ));
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
    public void removeEntityByID(int id) {
        Connection connection = connectionPool.getConnection( );
        String query = "DELETE FROM specializations WHERE specialization_id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute( );

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
    public List<Specialization> getAll() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM specializations";
        List<Specialization> specializationsList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    Specialization specializations = new Specialization(rs.getInt("specialization_id"), rs.getString("name"));
                    specializationsList.add(specializations);
                }
            }
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
        return specializationsList;
    }

    @Override
    public int getCountOfSpecialization() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT COUNT(*) from Specializations";
        int count = 0;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute( );
            try (ResultSet rs = statement.getResultSet()) {
                while(rs.next())
                    count = rs.getInt(1);
            }
        }catch (SQLException e) {
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
        return count;
    }
}