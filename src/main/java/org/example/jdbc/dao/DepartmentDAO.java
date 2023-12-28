package org.example.jdbc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.models.hospital.Department;
import org.example.interfaces.IDepartmentDAO;
import org.example.util.ConnectionPool;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO implements IDepartmentDAO {

    private final static Logger LOGGER = (Logger) LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void saveEntity(Department departments) {
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
    public Department getEntityByID(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM departments WHERE department_id = (?)";
        Department department = new Department();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    department.setDepartmentID(rs.getInt("department_id"));
                    department.setName(rs.getString("name"));
                    department.setNursesList(new DepartmentHasNurseDAO().getNursesByDepartment(id));
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
        return department;
    }

    @Override
    public void updateEntity(Department departments) {
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
    public List<Department> getAll() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM departments";
        List<Department> departmentsList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    Department department = new Department();
                    department.setDepartmentID(rs.getInt("department_id"));
                    department.setName(rs.getString("name"));
                    department.setNursesList(new DepartmentHasNurseDAO().getNursesByDepartment(rs.getInt("department_id")));
                    departmentsList.add(department);
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
    public List<Department> getDepartmentSortedByName() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM departments ORDER BY name";
        List<Department> departmentsList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    Department department = new Department();
                    department.setDepartmentID(rs.getInt("department_id"));
                    department.setName(rs.getString("name"));
                    departmentsList.add(department);
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
