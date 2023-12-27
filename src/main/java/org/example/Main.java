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
        AppointmentsService appointmentsService = new AppointmentsService();
        List<Appointment> appointmentsList = appointmentsService.getAppointmentByPhysicianID(14);
        LOGGER.info(appointmentsList);

        DepartmentHasNurseService departmentHasNurseService = new DepartmentHasNurseService();
        DepartmentsHasNurse departmentsHasNurse = departmentHasNurseService.getEntityByID(3);
        LOGGER.info(departmentsHasNurse);

        DepartmentsService departmentsService = new DepartmentsService();
        List<Department> departmentsList = departmentsService.getDepartmentSortedByName();
        LOGGER.info(departmentsList);
        Department department = departmentsService.getEntityByID(3);
        department.setNursesList(departmentHasNurseService.addNursesToDepartment(department));
        LOGGER.info(department.getNursesList());

        ExaminationRoomsService examinationRoomsService = new ExaminationRoomsService();
        List<ExaminationRoom> examinationRoomsList = examinationRoomsService.getRoomsByType("private");
        LOGGER.info(examinationRoomsList);

        ManufacturersService manufacturersService = new ManufacturersService();
        String address = manufacturersService.getManufacturerAddressByName("Biocon");
        LOGGER.info(address);

        ProceduresService proceduresService = new ProceduresService();
        Procedure procedure = proceduresService.getTopProcedure();
        LOGGER.info("Top Procedure : " + procedure);

        SpecializationsService specializationsService = new SpecializationsService();
        int count = specializationsService.getCountOfSpecialization();
        LOGGER.info("No of Specializations : " + count);

        PositionsService positionsService = new PositionsService();
        LOGGER.info("Top positions : " + positionsService.getTopPosition(3));
        Position position = positionsService.getEntityByID(4);
        position.setName("Mid-Level");
        positionsService.updateEntity(position);

    }
}