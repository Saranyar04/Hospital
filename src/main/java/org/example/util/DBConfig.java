package org.example.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;


public class DBConfig {

    private final static Logger LOGGER = (Logger) LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static final Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = DBConfig.class.getResourceAsStream("/db.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
    public static final String URL = properties.getProperty("url");
    public static final String USERNAME = properties.getProperty("user");
    public static final String PASSWORD = properties.getProperty("password");

}
