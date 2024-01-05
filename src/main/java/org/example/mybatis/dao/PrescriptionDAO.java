package org.example.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.interfaces.IPrescriptionDAO;
import org.example.models.hospital.Prescription;
import org.example.util.MyBatisSqlFactory;

import java.util.List;

public class PrescriptionDAO implements IPrescriptionDAO{

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void saveEntity(Prescription prescription) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPrescriptionDAO prescriptionDAO = sqlSession.getMapper(IPrescriptionDAO.class);
            prescriptionDAO.saveEntity(prescription);
            sqlSession.commit();
        }
    }

    @Override
    public Prescription getEntityByID(int id) {
        Prescription prescription;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPrescriptionDAO prescriptionDAO = sqlSession.getMapper(IPrescriptionDAO.class);
            prescription = prescriptionDAO.getEntityByID(id);
        }
        return prescription;
    }

    @Override
    public void updateEntity(Prescription prescription) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPrescriptionDAO prescriptionDAO = sqlSession.getMapper(IPrescriptionDAO.class);
            prescriptionDAO.updateEntity(prescription);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPrescriptionDAO prescriptionDAO = sqlSession.getMapper(IPrescriptionDAO.class);
            prescriptionDAO.removeEntityByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Prescription> getAll() {
        List<Prescription> prescriptionList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPrescriptionDAO prescriptionDAO = sqlSession.getMapper(IPrescriptionDAO.class);
            prescriptionList = prescriptionDAO.getAll();
        }
        return prescriptionList;
    }

    @Override
    public List<Prescription> getPrescriptionByPatientID(int patientID) {
        List<Prescription> prescriptionList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPrescriptionDAO prescriptionDAO = sqlSession.getMapper(IPrescriptionDAO.class);
            prescriptionList = prescriptionDAO.getPrescriptionByPatientID(patientID);
        }
        return prescriptionList;
    }
}
