package org.example.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public class MyBatisSqlFactory {

    private static final Logger LOGGER = LogManager.getLogger(MyBatisSqlFactory.class);
    private static SqlSessionFactory sqlSessionFactory;

    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            LOGGER.info(e);
        }
    }

    public MyBatisSqlFactory() {
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}