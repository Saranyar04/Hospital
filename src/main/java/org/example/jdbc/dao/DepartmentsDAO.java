package org.example.jdbc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.models.hospital.Departments;
import org.example.interfaces.IDepartmentsDAO;
import org.example.util.ConnectionPool;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentsDAO implements IDepartmentsDAO {

    private final static Logger LOGGER = (Logger) LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void saveEntity(Departments departments) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO departments (name) VALUES ((?))";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, departments.getDepartmentID());
            statement.setString(2, departments.getName());
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
    public Departments getEntityByID(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM departments WHERE department_id = (?)";
        Departments departments = new Departments();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    departments.setDepartmentID(rs.getInt("department_id"));
                    departments.setName(rs.getString("name"));
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
        return departments;
    }

    @Override
    public void updateEntity(Departments departments) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE departments SET name = (?) WHERE department_id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, departments.getName());
            statement.setInt(2, departments.getDepartmentID());
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
    public void removeEntityByID(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "DELETE FROM departments WHERE department_id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();

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
    public List<Departments> getAll() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM departments";
        List<Departments> departmentsList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    Departments departments = new Departments();
                    departments.setDepartmentID(rs.getInt("department_id"));
                    departments.setName(rs.getString("name"));
                    departmentsList.add(departments);
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
        return departmentsList;
    }

    @Override
    public List<Departments> getDepartmentOrderByName() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM departments ORDER BY name";
        List<Departments> departmentsList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    Departments departments = new Departments();
                    departments.setDepartmentID(rs.getInt("department_id"));
                    departments.setName(rs.getString("name"));
                    departmentsList.add(departments);
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
        return departmentsList;
    }
}
