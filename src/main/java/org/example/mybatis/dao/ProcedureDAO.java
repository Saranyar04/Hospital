package org.example.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.interfaces.IProcedureDAO;
import org.example.models.hospital.Procedure;
import org.example.util.MyBatisSqlFactory;

import java.util.List;

public class ProcedureDAO implements IProcedureDAO {

    private static SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void saveEntity(Procedure procedure) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IProcedureDAO procedureDAO = sqlSession.getMapper(IProcedureDAO.class);
            procedureDAO.saveEntity(procedure);
            sqlSession.commit();
        }
    }

    @Override
    public Procedure getEntityByID(int id) {
        Procedure procedure;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IProcedureDAO procedureDAO = sqlSession.getMapper(IProcedureDAO.class);
            procedure = procedureDAO.getEntityByID(id);
        }
        return procedure;
    }

    @Override
    public void updateEntity(Procedure procedure) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IProcedureDAO procedureDAO = sqlSession.getMapper(IProcedureDAO.class);
            procedureDAO.updateEntity(procedure);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IProcedureDAO procedureDAO = sqlSession.getMapper(IProcedureDAO.class);
            procedureDAO.removeEntityByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Procedure> getAll() {
        List<Procedure> procedureList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IProcedureDAO procedureDAO = sqlSession.getMapper(IProcedureDAO.class);
            procedureList = procedureDAO.getAll();
        }
        return procedureList;
    }

    @Override
    public Procedure getTopProcedure() {
        Procedure procedure;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IProcedureDAO procedureDAO = sqlSession.getMapper(IProcedureDAO.class);
            procedure = procedureDAO.getTopProcedure();
        }
        return procedure;
    }
}
