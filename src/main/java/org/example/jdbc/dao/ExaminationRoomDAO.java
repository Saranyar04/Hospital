package org.example.jdbc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.models.hospital.ExaminationRoom;
import org.example.interfaces.IExaminationRoomDAO;
import org.example.util.ConnectionPool;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExaminationRoomDAO implements IExaminationRoomDAO {

    private final static Logger LOGGER = (Logger) LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void saveEntity(ExaminationRoom examinationRooms) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO examination_rooms (examination_room_no, room_type) VALUES ((?), (?))";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, examinationRooms.getExaminationRoomNo());
            statement.setString(2, examinationRooms.getRoomType());
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
    public ExaminationRoom getEntityByID(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM examination_rooms WHERE examination_room_no = (?)";
        ExaminationRoom examinationRooms = new ExaminationRoom();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while(rs.next()) {
                    examinationRooms.setExaminationRoomNo(rs.getInt("examination_room_no"));
                    examinationRooms.setRoomType(rs.getString("room_type"));
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
        return examinationRooms;
    }

    @Override
    public void updateEntity(ExaminationRoom examinationRooms) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE examination_rooms SET room_type = (?) WHERE examination_room_no = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, examinationRooms.getRoomType());
            statement.setInt(2, examinationRooms.getExaminationRoomNo());
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
        String query = "DELETE FROM examination_rooms WHERE examination_room_no = (?)";
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
    public List<ExaminationRoom> getAll() {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM Examination_rooms";
        List<ExaminationRoom> examinationRoomsList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    ExaminationRoom examinationRooms = new ExaminationRoom();
                    examinationRooms.setExaminationRoomNo(rs.getInt("examination_room_no"));
                    examinationRooms.setRoomType(rs.getString("room_type"));
                    examinationRoomsList.add(examinationRooms);
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
        return examinationRoomsList;
    }

    @Override
    public List<ExaminationRoom> getRoomsByType(String roomType) {
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM examination_rooms WHERE room_type = (?)";
        List<ExaminationRoom> examinationRoomsList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, roomType);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    ExaminationRoom examinationRooms = new ExaminationRoom();
                    examinationRooms.setExaminationRoomNo(rs.getInt("examination_room_no"));
                    examinationRooms.setRoomType(rs.getString("room_type"));
                    examinationRoomsList.add(examinationRooms);
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
        return examinationRoomsList;
    }
}
