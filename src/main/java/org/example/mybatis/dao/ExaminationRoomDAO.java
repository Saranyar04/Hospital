package org.example.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.interfaces.IExaminationRoomDAO;
import org.example.models.hospital.ExaminationRoom;
import org.example.util.MyBatisSqlFactory;

import java.util.List;

public class ExaminationRoomDAO implements IExaminationRoomDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void saveEntity(ExaminationRoom examinationRoom) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IExaminationRoomDAO examinationRoomDAO = sqlSession.getMapper(IExaminationRoomDAO.class);
            examinationRoomDAO.saveEntity(examinationRoom);
            sqlSession.commit();
        }
    }

    @Override
    public ExaminationRoom getEntityByID(int id) {
        ExaminationRoom examinationRoom;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IExaminationRoomDAO examinationRoomDAO = sqlSession.getMapper(IExaminationRoomDAO.class);
            examinationRoom = examinationRoomDAO.getEntityByID(id);
        }
        return examinationRoom;
    }

    @Override
    public void updateEntity(ExaminationRoom examinationRoom) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IExaminationRoomDAO examinationRoomDAO = sqlSession.getMapper(IExaminationRoomDAO.class);
            examinationRoomDAO.updateEntity(examinationRoom);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IExaminationRoomDAO examinationRoomDAO = sqlSession.getMapper(IExaminationRoomDAO.class);
            examinationRoomDAO.removeEntityByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<ExaminationRoom> getAll() {
        List<ExaminationRoom> examinationRoomList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IExaminationRoomDAO examinationRoomDAO = sqlSession.getMapper(IExaminationRoomDAO.class);
            examinationRoomList = examinationRoomDAO.getAll();
        }
        return examinationRoomList;
    }

    @Override
    public List<ExaminationRoom> getRoomsByType(String roomType) {
        List<ExaminationRoom> examinationRoomList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IExaminationRoomDAO examinationRoomDAO = sqlSession.getMapper(IExaminationRoomDAO.class);
            examinationRoomList = examinationRoomDAO.getRoomsByType(roomType);
        }
        return examinationRoomList;
    }
}
