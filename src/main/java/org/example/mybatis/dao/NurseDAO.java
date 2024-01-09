package org.example.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.interfaces.IManufacturerDAO;
import org.example.interfaces.INurseDAO;
import org.example.models.persons.Nurse;
import org.example.util.MyBatisSqlFactory;

import java.util.List;

public class NurseDAO implements INurseDAO{

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void saveEntity(Nurse nurse) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            INurseDAO nurseDAO = sqlSession.getMapper(INurseDAO.class);
            nurseDAO.saveEntity(nurse);
            sqlSession.commit();
        }
    }

    @Override
    public Nurse getEntityByID(int id) {
        Nurse nurse;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            INurseDAO nurseDAO = sqlSession.getMapper(INurseDAO.class);
            nurse = nurseDAO.getEntityByID(id);
        }
        return nurse;
    }

    @Override
    public void updateEntity(Nurse nurse) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            INurseDAO nurseDAO = sqlSession.getMapper(INurseDAO.class);
            nurseDAO.updateEntity(nurse);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IManufacturerDAO manufacturerDAO = sqlSession.getMapper(IManufacturerDAO.class);
            manufacturerDAO.removeEntityByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Nurse> getAll() {
        List<Nurse> nuseList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            INurseDAO nurseDAO = sqlSession.getMapper(INurseDAO.class);
            nuseList = nurseDAO.getAll();
        }
        return nuseList;
    }

    @Override
    public List<Nurse> getNurseByPositionID(int positionID) {
        List<Nurse> nuseList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            INurseDAO nurseDAO = sqlSession.getMapper(INurseDAO.class);
            nuseList = nurseDAO.getNurseByPositionID(positionID);
        }
        return nuseList;
    }
}
