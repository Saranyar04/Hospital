package org.example.jdbc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.interfaces.IPhysiciansDAO;
import org.example.models.persons.Physicians;
import org.example.util.ConnectionPool;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhysiciansDAO implements IPhysiciansDAO {

    private final static Logger LOGGER = (Logger) LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private final DepartmentsDAO departmentsDAO = new DepartmentsDAO();
    private final PositionsDAO positionsDAO = new PositionsDAO();
    private final SpecializationsDAO specializationsDAO = new SpecializationsDAO();

    @Override
    public void saveEntity(Physicians physicians) {
        Connection connection = connectionPool.getConnection();
        departmentsDAO.saveEntity(physicians.getDepartments());
        positionsDAO.saveEntity(physicians.getPositions());
        specializationsDAO.saveEntity(physicians.getSpecializations());
        String query = "INSERT INTO physicians (first_name, last_name, address, department_id, position_id, specialization_id) VALUES ((?), (?), (?), (?), (?), (?))";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, physicians.getFirstName());
            statement.setString(2, physicians.getLastName());
            statement.setString(3, physicians.getAddress());
            statement.setInt(4, physicians.getDepartments().getDepartmentID());
            statement.setInt(5, physicians.getPositions().getPositionID());
            statement.setInt(6, physicians.getSpecializations().getSpcializationID());
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
    public Physicians getEntityByID(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM physicians WHERE physician_id = (?)";
        Physicians physicians = new Physicians();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while(rs.next()) {
                    physicians.setPhysicianID(rs.getInt("physician_id"));
                    physicians.setFirstName(rs.getString("first_name"));
                    physicians.setLastName(rs.getString("last_name"));
                    physicians.setAddress(rs.getString("address"));
                    physicians.setDepartments(departmentsDAO.getEntityByID(rs.getInt("department_id")));
                    physicians.setPositions(positionsDAO.getEntityByID(rs.getInt("position_id")));
                    physicians.setSpecializations(specializationsDAO.getEntityByID(rs.getInt("specialization_id")));
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
        return physicians;
    }

    @Override
    public void updateEntity(Physicians physicians) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE physicians SET first_name = (?), last_name = (?) WHERE physician_id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, physicians.getFirstName());
            statement.setString(2, physicians.getLastName());
            statement.setInt(3, physicians.getPhysicianID());
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
        String query = "DELETE FROM physicians WHERE physician_id = (?)";
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
    public List<Physicians> getAll() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM physicians";
        List<Physicians> physiciansList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    Physicians physicians = new Physicians();
                    physicians.setPhysicianID(rs.getInt("physician_id"));
                    physicians.setFirstName(rs.getString("first_name"));
                    physicians.setLastName(rs.getString("last_name"));
                    physicians.setAddress(rs.getString("address"));
                    physicians.setDepartments(departmentsDAO.getEntityByID(rs.getInt("department_id")));
                    physicians.setPositions(positionsDAO.getEntityByID(rs.getInt("position_id")));
                    physicians.setSpecializations(specializationsDAO.getEntityByID(rs.getInt("specilization_id")));
                    physiciansList.add(physicians);
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
        return physiciansList;
    }
    @Override
    public String getAddressByID(int departmentID) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT address FROM physicians WHERE physician_id = (?)";
        String address = null;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, departmentID);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while(rs.next()) {
                    address = rs.getString(1);
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
        return address;
    }
}
