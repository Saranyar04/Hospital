package org.example.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.interfaces.IPatientDAO;
import org.example.models.persons.Patient;
import org.example.util.MyBatisSqlFactory;

import java.util.List;

public class PatientDAO implements IPatientDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void saveEntity(Patient patient) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPatientDAO patientDAO = sqlSession.getMapper(IPatientDAO.class);
            patientDAO.saveEntity(patient);
            sqlSession.commit();
        }
    }

    @Override
    public Patient getEntityByID(int id) {
        Patient patient;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPatientDAO patientDAO = sqlSession.getMapper(IPatientDAO.class);
            patient = patientDAO.getEntityByID(id);
        }
        return patient;
    }

    @Override
    public void updateEntity(Patient patient) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPatientDAO patientDAO = sqlSession.getMapper(IPatientDAO.class);
            patientDAO.updateEntity(patient);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPatientDAO patientDAO = sqlSession.getMapper(IPatientDAO.class);
            patientDAO.removeEntityByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Patient> getAll() {
        List<Patient> patientList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPatientDAO patientDAO = sqlSession.getMapper(IPatientDAO.class);
            patientList = patientDAO.getAll();
        }
        return patientList;
    }

    @Override
    public List<Patient> getPatientByPhysicianID(int physicianID) {
        List<Patient> patientList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPatientDAO patientDAO = sqlSession.getMapper(IPatientDAO.class);
            patientList = patientDAO.getPatientByPhysicianID(physicianID);
        }
        return patientList;
    }
}
