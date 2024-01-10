package org.example.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import java.io.File;

import java.io.IOException;

public class JacksonMarshaller<T> {

    private static Logger LOGGER = (Logger) LogManager.getLogger(JacksonMarshaller.class);

    public static <T> void writeFile(T object, String path) {

        ObjectMapper objectMapper = new ObjectMapper( ).enable(SerializationFeature.INDENT_OUTPUT);
        try {
            objectMapper.writerWithDefaultPrettyPrinter( ).writeValue(new File(path), object);
        } catch (IOException e) {
            LOGGER.error(e);
        }

    }
    public static <T> T readValue(String path, Class<T> type) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return(T) objectMapper.readValue(new File(path), type);
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return null;
    }
}
