package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.models.hospital.*;
import org.example.services.*;

import java.util.List;

public class Main {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        AppointmentsService appointmentsService = new AppointmentsService();
        List<Appointments> appointmentsList = appointmentsService.getAppointmentByPhysician(14);
        LOGGER.info(appointmentsList);

        DepartmentHasNurseSrevice departmentHasNurseSrevice = new DepartmentHasNurseSrevice();
        DepartmentsHasNurse departmentsHasNurse = departmentHasNurseSrevice.getEntityByID(3);
        LOGGER.info(departmentsHasNurse);

        DepartmentsService departmentsService = new DepartmentsService();
        List<Departments> departmentsList = departmentsService.getDepartmentOrderByName();
        LOGGER.info(departmentsList);

        ExaminationRoomsService examinationRoomsService = new ExaminationRoomsService();
        List<ExaminationRooms> examinationRoomsList = examinationRoomsService.getRoomsbyType("private");
        LOGGER.info(examinationRoomsList);

        ManufacturersService manufacturersService = new ManufacturersService();
        String address = manufacturersService.getManufacturerAddressByName("Biocon");
        LOGGER.info(address);

        ProceduresService proceduresService = new ProceduresService();
        Procedures procedures = proceduresService.getTopProcedure();
        LOGGER.info("Top Procedure : " + procedures);

        SpecializationsService specializationsService = new SpecializationsService();
        int count = specializationsService.getCountOfSpecialization();
        LOGGER.info("No of Specializations : " + count);

        PositionsService positionsService = new PositionsService();
        LOGGER.info("Top 3 positions : " + positionsService.getTopThree());
    }
}