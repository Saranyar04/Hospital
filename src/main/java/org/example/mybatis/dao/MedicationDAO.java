package org.example.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.interfaces.IMedicationDAO;
import org.example.models.hospital.Medication;
import org.example.util.MyBatisSqlFactory;

import java.util.List;

public class MedicationDAO implements IMedicationDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void saveEntity(Medication medication) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IMedicationDAO medicationDAO = sqlSession.getMapper(IMedicationDAO.class);
            medicationDAO.saveEntity(medication);
            sqlSession.commit();
        }
    }

    @Override
    public Medication getEntityByID(int id) {
        Medication medication;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IMedicationDAO medicationDAO = sqlSession.getMapper(IMedicationDAO.class);
            medication = medicationDAO.getEntityByID(id);
        }
        return medication;
    }

    @Override
    public void updateEntity(Medication medication) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IMedicationDAO medicationDAO = sqlSession.getMapper(IMedicationDAO.class);
            medicationDAO.updateEntity(medication);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IMedicationDAO medicationDAO = sqlSession.getMapper(IMedicationDAO.class);
            medicationDAO.removeEntityByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Medication> getAll() {
        List<Medication> medicationList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IMedicationDAO medicationDAO = sqlSession.getMapper(IMedicationDAO.class);
            medicationList = medicationDAO.getAll();
        }
        return medicationList;
    }

    @Override
    public List<Medication> getMedicationsByManufacturerID(int manufacturerID) {
        List<Medication> medicationList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IMedicationDAO medicationDAO = sqlSession.getMapper(IMedicationDAO.class);
            medicationList = medicationDAO.getMedicationsByManufacturerID(manufacturerID);
        }
        return medicationList;
    }
}
