package org.example.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.interfaces.IDepartmentDAO;
import org.example.models.hospital.Department;
import org.example.util.MyBatisSqlFactory;

import java.util.List;

public class DepartmentDAO implements IDepartmentDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void saveEntity(Department department) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IDepartmentDAO departmentDAO = sqlSession.getMapper(IDepartmentDAO.class);
            departmentDAO.saveEntity(department);
            sqlSession.commit();
        }
    }

    @Override
    public Department getEntityByID(int id) {
        Department department;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IDepartmentDAO departmentDAO = sqlSession.getMapper(IDepartmentDAO.class);
            department = departmentDAO.getEntityByID(id);
        }
        return department;
    }

    @Override
    public void updateEntity(Department department) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IDepartmentDAO departmentDAO = sqlSession.getMapper(IDepartmentDAO.class);
            departmentDAO.updateEntity(department);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IDepartmentDAO departmentDAO = sqlSession.getMapper(IDepartmentDAO.class);
            departmentDAO.removeEntityByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Department> getAll() {
        List<Department> departmentList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IDepartmentDAO departmentDAO = sqlSession.getMapper(IDepartmentDAO.class);
            departmentList = departmentDAO.getAll();
        }
        return departmentList;
    }

    @Override
    public List<Department> getDepartmentSortedByName() {
        List<Department> departmentList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IDepartmentDAO departmentDAO = sqlSession.getMapper(IDepartmentDAO.class);
            departmentList = departmentDAO.getDepartmentSortedByName();
        }
        return departmentList;
    }
}
