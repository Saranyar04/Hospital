package org.example.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.interfaces.IDepartmentDAO;
import org.example.interfaces.IDepartmentHasNurseDAO;
import org.example.models.hospital.DepartmentsHasNurse;
import org.example.models.persons.Nurse;
import org.example.util.MyBatisSqlFactory;

import java.util.List;

public class DepartmentHasNurseDAO implements IDepartmentHasNurseDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void saveEntity(DepartmentsHasNurse departmentsHasNurse) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IDepartmentHasNurseDAO departmentHasNurseDAO = sqlSession.getMapper(IDepartmentHasNurseDAO.class);
            departmentHasNurseDAO.saveEntity(departmentsHasNurse);
            sqlSession.commit();
        }
    }

    @Override
    public DepartmentsHasNurse getEntityByID(int id) {
        DepartmentsHasNurse departmentsHasNurse;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IDepartmentHasNurseDAO departmentHasNurseDAO = sqlSession.getMapper(IDepartmentHasNurseDAO.class);
            departmentsHasNurse = departmentHasNurseDAO.getEntityByID(id);
        }
        return departmentsHasNurse;
    }

    @Override
    public void updateEntity(DepartmentsHasNurse departmentsHasNurse) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IDepartmentHasNurseDAO departmentHasNurseDAO = sqlSession.getMapper(IDepartmentHasNurseDAO.class);
            departmentHasNurseDAO.updateEntity(departmentsHasNurse);
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
    public List<DepartmentsHasNurse> getAll() {
        List<DepartmentsHasNurse> departmentHasNurseList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IDepartmentHasNurseDAO departmentHasNurseDAO = sqlSession.getMapper(IDepartmentHasNurseDAO.class);
            departmentHasNurseList = departmentHasNurseDAO.getAll();
        }
        return departmentHasNurseList;
    }

    @Override
    public List<DepartmentsHasNurse> getDepartmentByNurseID(int nurseID) {
        List<DepartmentsHasNurse> departmentHasNurseList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IDepartmentHasNurseDAO departmentHasNurseDAO = sqlSession.getMapper(IDepartmentHasNurseDAO.class);
            departmentHasNurseList = departmentHasNurseDAO.getDepartmentByNurseID(nurseID);
        }
        return departmentHasNurseList;
    }

    @Override
    public List<Nurse> getNursesByDepartment(int id) {
        List<Nurse> nurseList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IDepartmentHasNurseDAO departmentHasNurseDAO = sqlSession.getMapper(IDepartmentHasNurseDAO.class);
            nurseList = departmentHasNurseDAO.getNursesByDepartment(id);
        }
        return nurseList;
    }
}
