package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.models.hospital.*;
import org.example.models.persons.Position;
import org.example.services.*;

import java.util.List;

public class Main {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        AppointmentService appointmentService = new AppointmentService();
        List<Appointment> appointmentsList = appointmentService.getAppointmentByPhysicianID(14);
        LOGGER.info(appointmentsList);

        DepartmentHasNurseService departmentHasNurseService = new DepartmentHasNurseService();
        DepartmentsHasNurse departmentsHasNurse = departmentHasNurseService.getEntityByID(3);
        LOGGER.info(departmentsHasNurse);

        DepartmentService departmentService = new DepartmentService();
        List<Department> departmentsList = departmentService.getAll();
        LOGGER.info(departmentsList);
        Department department = departmentService.getEntityByID(3);
        department.setNursesList(departmentHasNurseService.getNursesByDepartment(department));
        LOGGER.info(department.getNursesList());

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
        positionService.updateEntity(position);

    }
}