package org.example.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.interfaces.IProcedureDAO;
import org.example.interfaces.ISpecializationDAO;
import org.example.models.hospital.Procedure;
import org.example.models.persons.Specialization;
import org.example.util.MyBatisSqlFactory;

import java.util.List;

public class SpecializationDAO implements ISpecializationDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void saveEntity(Specialization specialization) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISpecializationDAO specializationDAO = sqlSession.getMapper(ISpecializationDAO.class);
            specializationDAO.saveEntity(specialization);
            sqlSession.commit();
        }
    }

    @Override
    public Specialization getEntityByID(int id) {
        Specialization specialization;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISpecializationDAO specializationDAO = sqlSession.getMapper(ISpecializationDAO.class);
            specialization = specializationDAO.getEntityByID(id);
        }
        return specialization;
    }

    @Override
    public void updateEntity(Specialization specialization) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISpecializationDAO specializationDAO = sqlSession.getMapper(ISpecializationDAO.class);
            specializationDAO.updateEntity(specialization);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISpecializationDAO specializationDAO = sqlSession.getMapper(ISpecializationDAO.class);
            specializationDAO.removeEntityByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Specialization> getAll() {
        List<Specialization> specializationList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISpecializationDAO specializationDAO = sqlSession.getMapper(ISpecializationDAO.class);
            specializationList = specializationDAO.getAll();
        }
        return specializationList;
    }

    @Override
    public int getCountOfSpecialization() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISpecializationDAO specializationDAO = sqlSession.getMapper(ISpecializationDAO.class);
            return specializationDAO.getCountOfSpecialization();
        }
    }
}
