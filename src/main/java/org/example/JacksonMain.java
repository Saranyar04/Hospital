package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.models.hospital.Department;
import org.example.models.persons.*;
import org.example.mybatis.dao.*;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class JacksonMain {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(JacksonMain.class);
    public static void main(String[] args) throws ParseException {
        PositionDAO positionDAO = new PositionDAO();
        Position position = positionDAO.getEntityByID(2);
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("src/main/resources/jackson-json/position.json");
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, position);
        } catch (IOException e) {
            LOGGER.error(e);
        }

        NurseDAO nurseDAO = new NurseDAO();
        Nurse nurse1 = nurseDAO.getEntityByID(3);
        Nurse nurse2 = nurseDAO.getEntityByID(8);
        List<Nurse> nurseList = new ArrayList<>();
        nurseList.add(nurse1);
        nurseList.add(nurse2);
        DepartmentDAO departmentDAO = new DepartmentDAO();
        Department department = departmentDAO.getEntityByID(2);
        department.setNursesList(nurseList);
        file = new File("src/main/resources/jackson-json/department.json");
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, department);
        } catch (IOException e) {
            LOGGER.error(e);
        }


        SpecializationDAO specializationDAO = new SpecializationDAO();
        Specialization specialization = specializationDAO.getEntityByID(2);
        file = new File("src/main/resources/jackson-json/specialization.json");
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, specialization);
        } catch (IOException e) {
            LOGGER.error(e);
        }


        PhysicianDAO physicianDAO = new PhysicianDAO();
        Physician physician = physicianDAO.getEntityByID(12);
        file = new File("src/main/resources/jackson-json/physician.json");
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, physician);
        } catch (IOException e) {
            LOGGER.error(e);
        }

        PatientDAO patientDAO = new PatientDAO();
        Patient patient = patientDAO.getEntityByID(12);
        file = new File("src/main/resources/jackson-json/patient.json");
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, patient);
        } catch (IOException e) {
            LOGGER.error(e);
        }


        Patient patient1 = new Patient();
        try {
            patient1 = objectMapper.readValue(file, Patient.class);
        } catch (IOException e) {
            LOGGER.error(e);
        }
        LOGGER.info(patient1);
    }
}
