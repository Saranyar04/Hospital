package org.example.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool {

    private final static Logger LOGGER = (Logger) LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static ConnectionPool instance = null;
    private static final int INITIAL_POOL_SIZE = 10;
    private static final Vector<Connection> freeConnection = new Vector<>();
    private static final Vector<Connection> usedConnection = new Vector<>();

    public ConnectionPool() {
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
            create();
        }
        return instance;
    }

        public static void create() {
            for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
                freeConnection.add(createConnection(DBConfig.URL, DBConfig.USERNAME, DBConfig.PASSWORD));
            }
        }

        public static Connection createConnection(String url, String user, String password) {
            try {
                return DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            return null;
        }

        public synchronized  Connection getConnection() {
            Connection connection = freeConnection.remove(freeConnection.size() - 1);
            usedConnection.add(connection);
            return connection;
        }

        public synchronized void releaseConnection(Connection connection) throws SQLException {
            if (usedConnection.remove(connection)) {
                freeConnection.add(connection);
            } else
                throw new SQLException("The connection has already returned or it's not for this pool");
        }
    }

