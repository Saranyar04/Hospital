package org.example.jdbc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.models.hospital.Manufacturer;
import org.example.interfaces.IManufacturerDAO;
import org.example.util.ConnectionPool;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerDAO implements IManufacturerDAO {

    private final static Logger LOGGER = (Logger) LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void saveEntity(Manufacturer manufacturers) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO manufacturers (name, address) VALUES ((?), (?))";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, manufacturers.getName());
            statement.setString(2, manufacturers.getAddress());
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
    public Manufacturer getEntityByID(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM manufacturers WHERE manufacturer_id = (?)";
        Manufacturer manufacturers = new Manufacturer();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while(rs.next()) {
                    manufacturers.setManufacturerID(rs.getInt("manufacturer_id"));
                    manufacturers.setName(rs.getString("name"));
                    manufacturers.setAddress(rs.getString("address"));
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
        return manufacturers;
    }

    @Override
    public void updateEntity(Manufacturer manufacturers) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE manufacturers SET name = (?), address = (?) WHERE manufacturer_id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, manufacturers.getName());
            statement.setString(2, manufacturers.getAddress());
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
        String query = "DELETE FROM manufacturers WHERE manufacturer_id = (?)";
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
    public List<Manufacturer> getAll() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM manufacturers";
        List<Manufacturer> manufacturersList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    Manufacturer manufacturers = new Manufacturer();
                    manufacturers.setManufacturerID(rs.getInt("manufacturer_id"));
                    manufacturers.setName(rs.getString("name"));
                    manufacturers.setAddress(rs.getString("address"));
                    manufacturersList.add(manufacturers);
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
        return manufacturersList;
    }

    @Override
    public String getManufacturerAddressByName(String name) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT address FROM manufacturers WHERE name = (?)";
        String address = null;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while(rs.next())
                    address = rs.getString(1);
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
        return address;
    }
}
