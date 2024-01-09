package org.example.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.interfaces.IPhysicianDAO;
import org.example.models.persons.Physician;
import org.example.util.MyBatisSqlFactory;

import java.util.List;

public class PhysicianDAO implements IPhysicianDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void saveEntity(Physician physician) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPhysicianDAO physicianDAO = sqlSession.getMapper(IPhysicianDAO.class);
            physicianDAO.saveEntity(physician);
            sqlSession.commit();
        }
    }

    @Override
    public Physician getEntityByID(int id) {
        Physician physician;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPhysicianDAO physicianDAO = sqlSession.getMapper(IPhysicianDAO.class);
            physician = physicianDAO.getEntityByID(id);
        }
        return physician;
    }

    @Override
    public void updateEntity(Physician physician) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPhysicianDAO physicianDAO = sqlSession.getMapper(IPhysicianDAO.class);
            physicianDAO.updateEntity(physician);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPhysicianDAO physicianDAO = sqlSession.getMapper(IPhysicianDAO.class);
            physicianDAO.removeEntityByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Physician> getAll() {
        List<Physician> physicianList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPhysicianDAO physicianDAO = sqlSession.getMapper(IPhysicianDAO.class);
            physicianList = physicianDAO.getAll();
        }
        return physicianList;
    }

    @Override
    public String getAddressByID(int departmentID) {
        String address;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPhysicianDAO physicianDAO = sqlSession.getMapper(IPhysicianDAO.class);
            address = physicianDAO.getAddressByID(departmentID);
        }
        return address;
    }
}
