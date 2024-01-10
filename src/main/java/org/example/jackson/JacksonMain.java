package org.example.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.models.hospital.Department;
import org.example.models.persons.*;
import org.example.mybatis.dao.*;

import java.util.ArrayList;
import java.util.List;

import static org.example.jackson.JacksonMarshaller.readValue;
import static org.example.jackson.JacksonMarshaller.writeFile;

public class JacksonMain {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(JacksonMain.class);

    public static void main(String[] args) {
        PositionDAO positionDAO = new PositionDAO();
        Position position = positionDAO.getEntityByID(2);
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        writeFile(position, "src/main/resources/jackson-json/position.json");

        NurseDAO nurseDAO = new NurseDAO();
        Nurse nurse1 = nurseDAO.getEntityByID(3);
        Nurse nurse2 = nurseDAO.getEntityByID(8);
        List<Nurse> nurseList = new ArrayList<>();
        nurseList.add(nurse1);
        nurseList.add(nurse2);
        DepartmentDAO departmentDAO = new DepartmentDAO();
        Department department = departmentDAO.getEntityByID(2);
        department.setNursesList(nurseList);
        writeFile(department, "src/main/resources/jackson-json/department.json");

        SpecializationDAO specializationDAO = new SpecializationDAO();
        Specialization specialization = specializationDAO.getEntityByID(2);
        writeFile(specialization, "src/main/resources/jackson-json/specialization.json");

        PhysicianDAO physicianDAO = new PhysicianDAO();
        Physician physician = physicianDAO.getEntityByID(12);
        writeFile(physician, "src/main/resources/jackson-json/physician.json");

        PatientDAO patientDAO = new PatientDAO();
        Patient patient = patientDAO.getEntityByID(12);
        writeFile(patient, "src/main/resources/jackson-json/patient.json");

        Patient patient1 = new Patient();
        patient1 = readValue("src/main/resources/jackson-json/patient.json", Patient.class);
        LOGGER.info(patient1);
    }
}
