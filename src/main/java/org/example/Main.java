package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.models.hospital.*;
import org.example.models.persons.*;
import org.example.mybatis.dao.*;

import java.util.List;

public class Main {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        /*AppointmentService appointmentService = new AppointmentService();
        List<Appointment> appointmentsList = appointmentService.getAppointmentByPhysicianID(14);
        LOGGER.info(appointmentsList);

        DepartmentHasNurseService departmentHasNurseService = new DepartmentHasNurseService();
        DepartmentsHasNurse departmentsHasNurse = departmentHasNurseService.getEntityByID(3);
        LOGGER.info(departmentsHasNurse);

        DepartmentService departmentService = new DepartmentService();
        List<Department> departmentsList = departmentService.getAll();
        LOGGER.info(departmentsList);
        Department department = departmentService.getEntityByID(3);
        LOGGER.info(department);


        ExaminationRoomService examinationRoomService = new ExaminationRoomService();
        List<ExaminationRoom> examinationRoomsList = examinationRoomService.getRoomsByType("private");
        LOGGER.info(examinationRoomsList);

        ManufacturerService manufacturerService = new ManufacturerService();
        String address = manufacturerService.getManufacturerAddressByName("Biocon");
        LOGGER.info(address);

        ProcedureService procedureService = new ProcedureService();
        Procedure procedure = procedureService.getTopProcedure();
        LOGGER.info("Top Procedure : " + procedure);

        SpecializationService specializationService = new SpecializationService();
        int count = specializationService.getCountOfSpecialization();
        LOGGER.info("No of Specializations : " + count);

        PositionService positionService = new PositionService();
        LOGGER.info("Top positions : " + positionService.getTopPosition(3));
        Position position = positionService.getEntityByID(4);
        position.setName("Mid-Level");
        positionService.updateEntity(position);*/

        PositionDAO positionDAO = new PositionDAO();
        List<Position> positionList = positionDAO.getAll();
        LOGGER.info(positionList);

        ExaminationRoomDAO examinationRoomDAO = new ExaminationRoomDAO();
        List<ExaminationRoom> examinationRoomList = examinationRoomDAO.getAll();
        LOGGER.info(examinationRoomList);

        SpecializationDAO specializationDAO = new SpecializationDAO();
        Specialization specialization = specializationDAO.getEntityByID(3);
        LOGGER.info(specialization);

        DepartmentDAO departmentDAO = new DepartmentDAO();
        Department department = departmentDAO.getEntityByID(3);
        LOGGER.info(department);

        PhysicianDAO physicianDAO = new PhysicianDAO();
        List<Physician> physicianList = physicianDAO.getAll();
        LOGGER.info(physicianList);

        PatientDAO patientDAO = new PatientDAO();
        Patient patient = patientDAO.getEntityByID(5);
        LOGGER.info(patient);

        ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
        String manufacturer = manufacturerDAO.getManufacturerAddressByName("Alcon");
        LOGGER.info(manufacturer);
    }
}