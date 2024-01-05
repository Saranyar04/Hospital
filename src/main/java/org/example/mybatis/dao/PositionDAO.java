package org.example.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.interfaces.IPositionDAO;
import org.example.models.persons.Position;
import org.example.util.MyBatisSqlFactory;

import java.util.List;

public class PositionDAO implements IPositionDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void saveEntity(Position position) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPositionDAO positionDAO = sqlSession.getMapper(IPositionDAO.class);
            positionDAO.saveEntity(position);
            sqlSession.commit();
        }
    }

    @Override
    public Position getEntityByID(int id) {
        Position position;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPositionDAO positionDAO = sqlSession.getMapper(IPositionDAO.class);
            position = positionDAO.getEntityByID(id);
        }
        return position;
    }

    @Override
    public void updateEntity(Position position) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPositionDAO positionDAO = sqlSession.getMapper(IPositionDAO.class);
            positionDAO.updateEntity(position);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntityByID(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPositionDAO positionDAO = sqlSession.getMapper(IPositionDAO.class);
            positionDAO.removeEntityByID(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Position> getAll() {
        List<Position> positionList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPositionDAO positionDAO = sqlSession.getMapper(IPositionDAO.class);
            positionList = positionDAO.getAll();
        }
        return positionList;
    }

    @Override
    public List<Position> getTopPosition(int limit) {
        List<Position> positionList;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPositionDAO positionDAO = sqlSession.getMapper(IPositionDAO.class);
            positionList = positionDAO.getTopPosition(limit);
        }
        return positionList;
    }
}
