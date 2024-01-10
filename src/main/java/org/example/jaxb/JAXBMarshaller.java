package org.example.jaxb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.models.hospital.Department;
import org.example.models.persons.Patient;
import org.example.models.persons.Physician;
import org.example.models.persons.Specialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JAXBMarshaller<T> {

    private static Logger LOGGER = (Logger) LogManager.getLogger(JAXBMarshaller.class);

    public static <T> void marshal(T object, String path) {
        try {
            JAXBContext context = JAXBContext.newInstance(Department.class, Specialization.class, Physician.class, Patient.class);
            Marshaller marshaller = context.createMarshaller( );
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(object, new File(path));
        } catch (JAXBException e) {
            LOGGER.error(e);
        }
    }

    public static <T> T unmarshal(String path, Class<T> type) {
        try {
            JAXBContext context = JAXBContext.newInstance(type);
            return (T) context.createUnmarshaller( ).unmarshal(new FileReader(path));
        } catch (JAXBException | RuntimeException | FileNotFoundException e) {
            LOGGER.info(e);
        }
        return null;
    }
}
