package org.example.jdbc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.models.hospital.DepartmentsHasNurse;
import org.example.interfaces.IDepartmentHasNurseDAO;
import org.example.util.ConnectionPool;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentHasNurseDAO implements IDepartmentHasNurseDAO {

    private final static Logger LOGGER = (Logger) LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private final NursesDAO nursesDAO = new NursesDAO();
    private final DepartmentsDAO departmentsDAO = new DepartmentsDAO();

    @Override
    public void saveEntity(DepartmentsHasNurse departmentsHasNurse) {
        Connection connection = connectionPool.getConnection();
        nursesDAO.saveEntity(departmentsHasNurse.getNurses());
        departmentsDAO.saveEntity(departmentsHasNurse.getDepartments());
        String query = "INSERT INTO department_has_nurse (department_id, nurse_id) VALUES ((?), (?))";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, departmentsHasNurse.getDepartments().getDepartmentID());
            statement.setInt(2, departmentsHasNurse.getNurses().getNurseID());
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
    public DepartmentsHasNurse getEntityByID(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM department_has_nurse WHERE department_id = (?)";
        DepartmentsHasNurse departmentsHasNurse = new DepartmentsHasNurse();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while(rs.next()) {
                    departmentsHasNurse.setDepartments(departmentsDAO.getEntityByID(rs.getInt("department_id")));
                    departmentsHasNurse.setNurses(nursesDAO.getEntityByID(rs.getInt("nurse_id")));
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
        return departmentsHasNurse;
    }

    @Override
    public void updateEntity(DepartmentsHasNurse departmentsHasNurse) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE department_has_nurse SET nurse_id = (?) WHERE department_id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, departmentsHasNurse.getDepartments().getDepartmentID());
            statement.setInt(2, departmentsHasNurse.getNurses().getNurseID());
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
        String query = "DELETE FROM department_has_nurse WHERE department_id = (?)";
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
    public List<DepartmentsHasNurse> getAll() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM department_has_nurse";
        List<DepartmentsHasNurse> departmentsHasNursesList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    DepartmentsHasNurse departmentsHasNurse = new DepartmentsHasNurse();
                    departmentsHasNurse.setDepartments(departmentsDAO.getEntityByID(rs.getInt("department_id")));
                    departmentsHasNurse.setNurses(nursesDAO.getEntityByID(rs.getInt("nurse_id")));
                    departmentsHasNursesList.add(departmentsHasNurse);
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
        return departmentsHasNursesList;
    }

    @Override
    public List<DepartmentsHasNurse> getDepartmentByNurse(int nurseID) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM department_has_nurse WHERE nurse_id = (?)";
        List<DepartmentsHasNurse> departmentsHasNursesList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, nurseID);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    DepartmentsHasNurse departmentsHasNurse = new DepartmentsHasNurse();
                    departmentsHasNurse.setDepartments(departmentsDAO.getEntityByID(rs.getInt("department_id")));
                    departmentsHasNurse.setNurses(nursesDAO.getEntityByID(rs.getInt("nurse_id")));
                    departmentsHasNursesList.add(departmentsHasNurse);
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
        return departmentsHasNursesList;
    }
}
