package org.example.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.interfaces.IManufacturerDAO;
import org.example.models.hospital.Manufacturer;
import org.example.util.MyBatisSqlFactory;

import java.util.List;

public class ManufacturerDAO implements IManufacturerDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void saveEntity(Manufacturer manufacturer) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IManufacturerDAO manufacturerDAO = sqlSession.getMapper(IManufacturerDAO.class);
            manufacturerDAO.saveEntity(manufacturer);
            sqlSession.commit();
            }
    }

    @Override
    public Manufacturer getEntityByID(int id) {
        Manufacturer manufacturer;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IManufacturerDAO manufacturerDAO = sqlSession.getMapper(IManufacturerDAO.class);
            manufacturer = manufacturerDAO.getEntityByID(id);
        }
        return manufacturer;
    }

    @Override
    public void updateEntity(Manufacturer manufacturer) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IManufacturerDAO manufacturerDAO = sqlSession.getMapper(IManufacturerDAO.class);
            manufacturerDAO.updateEntity(manufacturer);
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
    public List<Manufacturer> getAll() {
        List<Manufacturer> manufacturerList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IManufacturerDAO manufacturerDAO = sqlSession.getMapper(IManufacturerDAO.class);
            manufacturerList = manufacturerDAO.getAll();
        }
        return manufacturerList;
    }

    @Override
    public String getManufacturerAddressByName(String name) {
        String address;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IManufacturerDAO manufacturerDAO = sqlSession.getMapper(IManufacturerDAO.class);
            address = manufacturerDAO.getManufacturerAddressByName(name);
        }
        return address;
    }
}
