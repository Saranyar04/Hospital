package org.example.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.interfaces.IAppointmentDAO;
import org.example.models.hospital.Appointment;
import org.example.util.MyBatisSqlFactory;

import java.util.List;

public class AppointmentDAO implements IAppointmentDAO {

    private static SqlSessionFactory sqlSessionFactory;
    public AppointmentDAO() {
        sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();
    }

    @Override
    public void saveEntity(Appointment appointment) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IAppointmentDAO appointmentDAO = sqlSession.getMapper(IAppointmentDAO.class);
            appointmentDAO.saveEntity(appointment);
            sqlSession.commit();
        }
    }

    @Override
    public Appointment getEntityByID(int id) {
        Appointment appointment;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IAppointmentDAO appointmentDAO = sqlSession.getMapper(IAppointmentDAO.class);
            appointment = appointmentDAO.getEntityByID(id);
        }
        return appointment;
    }

    @Override
    public void updateEntity(Appointment appointment) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IAppointmentDAO appointmentDAO = sqlSession.getMapper(IAppointmentDAO.class);
            appointmentDAO.updateEntity(appointment);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IAppointmentDAO appointmentDAO = sqlSession.getMapper(IAppointmentDAO.class);
            appointmentDAO.removeEntityByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Appointment> getAll() {
        List<Appointment> appointmentList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IAppointmentDAO appointmentDAO = sqlSession.getMapper(IAppointmentDAO.class);
            appointmentList = appointmentDAO.getAll();
        }
        return appointmentList;
    }

    @Override
    public List<Appointment> getAppointmentByPhysicianID(int id) {
        List<Appointment> appointmentList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IAppointmentDAO appointmentDAO = sqlSession.getMapper(IAppointmentDAO.class);
            appointmentList = appointmentDAO.getAppointmentByPhysicianID(id);
        }
        return appointmentList;
    }
}
