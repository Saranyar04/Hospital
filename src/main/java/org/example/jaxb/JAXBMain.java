package org.example.jaxb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.models.hospital.Department;
import org.example.models.persons.*;
import org.example.mybatis.dao.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.example.jaxb.JAXBMarshaller.marshal;
import static org.example.jaxb.JAXBMarshaller.unmarshal;

public class JAXBMain {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(JAXBMain.class);
    public static void main(String[] args) throws ParseException {
        PositionDAO positionDAO = new PositionDAO();
        Position position = positionDAO.getEntityByID(2);
        marshal(position, "src/main/resources/marshal-xml/position.xml");

        NurseDAO nurseDAO = new NurseDAO();
        Nurse nurse1 = nurseDAO.getEntityByID(3);
        Nurse nurse2 = nurseDAO.getEntityByID(8);
        List<Nurse> nurseList = new ArrayList<>();
        nurseList.add(nurse1);
        nurseList.add(nurse2);
        DepartmentDAO departmentDAO = new DepartmentDAO();
        Department department = departmentDAO.getEntityByID(2);
        department.setNursesList(nurseList);
        marshal(department, "src/main/resources/marshal-xml/department.xml");

        SpecializationDAO specializationDAO = new SpecializationDAO();
        Specialization specialization = specializationDAO.getEntityByID(2);
        marshal(specialization, "src/main/resources/marshal-xml/specialization.xml");

        PhysicianDAO physicianDAO = new PhysicianDAO();
        Physician physician = physicianDAO.getEntityByID(12);
        marshal(physician, "src/main/resources/marshal-xml/physician.xml");

        PatientDAO patientDAO = new PatientDAO();
        Patient patient = patientDAO.getEntityByID(12);
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2000-10-10");
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        patient.setDateOfBirth(date1);
        marshal(patient, "src/main/resources/marshal-xml/patient.xml");

        Patient patient1 = new Patient();
        patient1 = unmarshal("src/main/resources/marshal-xml/patient.xml", Patient.class);
        LOGGER.info(patient1);
    }
}
