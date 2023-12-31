package org.example.jdbc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.models.hospital.Procedure;
import org.example.interfaces.IProcedureDAO;
import org.example.util.ConnectionPool;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProcedureDAO implements IProcedureDAO {

    private final static Logger LOGGER = (Logger) LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void saveEntity(Procedure procedures) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO procedures (name, cost, description) VALUES ((?), (?), (?))";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, procedures.getName());
            statement.setDouble(2, procedures.getCost());
            statement.setString(3, procedures.getDescription());
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
    public Procedure getEntityByID(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM procedures WHERE procedure_id = (?)";
        Procedure procedures = new Procedure();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while(rs.next()) {
                    procedures.setProcedureID(rs.getInt("procedure_id"));
                    procedures.setName(rs.getString("name"));
                    procedures.setCost(rs.getDouble("cost"));
                    procedures.setDescription(rs.getString("description"));
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
        return procedures;
    }

    @Override
    public void updateEntity(Procedure procedures) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE procedures SET cost = (?) WHERE procedure_id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, procedures.getCost());
            statement.setInt(2, procedures.getProcedureID());
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
        String query = "DELETE FROM procedures WHERE procedure_id = (?)";
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
    public List<Procedure> getAll() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM procedures";
        List<Procedure> proceduresList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    Procedure procedures = new Procedure();
                    procedures.setProcedureID(rs.getInt("procedure_id"));
                    procedures.setName(rs.getString("name"));
                    procedures.setCost(rs.getDouble("cost"));
                    procedures.setDescription(rs.getString("description"));
                    proceduresList.add(procedures);
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
        return proceduresList;
    }

    @Override
    public Procedure getTopProcedure() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM procedures ORDER BY cost DESC LIMIT 1";
        Procedure procedures = new Procedure();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while(rs.next()) {
                    procedures.setProcedureID(rs.getInt("procedure_id"));
                    procedures.setName(rs.getString("name"));
                    procedures.setCost(rs.getDouble("cost"));
                    procedures.setDescription(rs.getString("description"));
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
        return procedures;
    }
}
