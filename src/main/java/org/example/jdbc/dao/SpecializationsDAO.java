package org.example.jdbc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.interfaces.ISpecializationsDAO;
import org.example.models.persons.Specializations;
import org.example.util.ConnectionPool;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecializationsDAO implements ISpecializationsDAO {

    private final static Logger LOGGER = (Logger) LogManager.getLogger(MethodHandles.lookup( ).lookupClass( ));
    private final ConnectionPool connectionPool = ConnectionPool.getInstance( );

    @Override
    public void saveEntity(Specializations specializations) {
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
    public Specializations getEntityByID(int id) {
        Connection connection = connectionPool.getConnection( );
        String query = "SELECT * FROM specializations WHERE specialization_id = (?)";
        Specializations specializations = new Specializations( );
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute( );
            try (ResultSet rs = statement.getResultSet( )) {
                while (rs.next( )) {
                    specializations.setSpcializationID(rs.getInt("specialization_id"));
                    specializations.setName(rs.getString("name"));
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
        return specializations;
    }

    @Override
    public void updateEntity(Specializations specializations) {
        Connection connection = connectionPool.getConnection( );
        String query = "UPDATE specializations SET name = (?) WHERE specialization_id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, specializations.getName( ));
            statement.setInt(2, specializations.getSpcializationID( ));
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
    public List<Specializations> getAll() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM specializations";
        List<Specializations> specializationsList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute( );
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    Specializations specializations = new Specializations();
                    specializations.setSpcializationID(rs.getInt("specialization_id"));
                    specializations.setName(rs.getString("name"));
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