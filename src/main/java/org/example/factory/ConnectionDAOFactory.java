package org.example.factory;

public class ConnectionDAOFactory {

    public IBaseDAOFactory getDAOFactory(DBConnectionType dbConnectionType) {

        IBaseDAOFactory daoFactory = null;
        if (dbConnectionType == DBConnectionType.JDBC) {
            daoFactory = new JDBCDAOFactory();
        } else if (dbConnectionType == DBConnectionType.MYBATIS) {
            daoFactory =  new MyBatisDAOFactory();
        } else {
            daoFactory = null;
        }

        return daoFactory;
    }
}
