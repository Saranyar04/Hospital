package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.example.factory.ConnectionDAOFactory;
import org.example.factory.DBConnectionType;
import org.example.factory.IBaseDAOFactory;
import org.example.interfaces.IBaseDAO;
import org.example.models.hospital.*;
import org.example.models.persons.*;
import org.example.mybatis.dao.*;

import java.util.List;

public class Main {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ConnectionDAOFactory connectionDAOFactory = new ConnectionDAOFactory();
        IBaseDAOFactory daoFactory = connectionDAOFactory.getDAOFactory(DBConnectionType.MYBATIS);
        IBaseDAO baseDAO = daoFactory.getDAO("appointments");
        List<Appointment> appointmentList;
        appointmentList= baseDAO.getAll();
        LOGGER.info(appointmentList);


        PositionDAO positionDAO = new PositionDAO();
        List<Position> positionList = positionDAO.getAll();
        LOGGER.info(positionList);
        Position position = positionDAO.getEntityByID(3);
        position.setName("Mid-Level");
        positionDAO.updateEntity(position);
        LOGGER.info(position);


        ExaminationRoomDAO examinationRoomDAO = new ExaminationRoomDAO();
        List<ExaminationRoom> examinationRoomList = examinationRoomDAO.getAll();
        LOGGER.info(examinationRoomList);
        examinationRoomList = examinationRoomDAO.getRoomsByType("private");
        LOGGER.info(examinationRoomList);

        SpecializationDAO specializationDAO = new SpecializationDAO();
        Specialization specialization = specializationDAO.getEntityByID(3);
        LOGGER.info(specialization);
        LOGGER.info("Specialization count : " + specializationDAO.getCountOfSpecialization());

        DepartmentDAO departmentDAO = new DepartmentDAO();
        Department department = departmentDAO.getEntityByID(3);
        LOGGER.info(department);
        List<Department> departmentList = departmentDAO.getDepartmentSortedByName();
        LOGGER.info(departmentList);

        PhysicianDAO physicianDAO = new PhysicianDAO();
        List<Physician> physicianList = physicianDAO.getAll();
        LOGGER.info(physicianList);
        LOGGER.info(physicianDAO.getAddressByID(3));

        PatientDAO patientDAO = new PatientDAO();
        Patient patient = patientDAO.getEntityByID(5);
        patient.setFirstName("Laura");
        patientDAO.updateEntity(patient);
        LOGGER.info(patient);
        List<Patient> patientList = patientDAO.getPatientByPhysicianID(2);
        LOGGER.info(patientList);

        ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
        String address = manufacturerDAO.getManufacturerAddressByName("Biocon");
        LOGGER.info(address);
        manufacturerDAO.removeEntityByID(7);
        Manufacturer manufacturer = manufacturerDAO.getEntityByID(4);
        LOGGER.info(manufacturer);

        DepartmentHasNurseDAO departmentHasNurseDAO = new DepartmentHasNurseDAO();
        List<DepartmentsHasNurse> departmentsHasNurseList = departmentHasNurseDAO.getDepartmentByNurseID(1);
        LOGGER.info(departmentsHasNurseList);
        LOGGER.info(departmentHasNurseDAO.getNursesByDepartment(3));

        ProcedureDAO procedureDAO = new ProcedureDAO();
        procedureDAO.removeEntityByID(9);
        LOGGER.info(procedureDAO.getAll());

        PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
        List<Prescription> prescriptionList = prescriptionDAO.getAll();
        LOGGER.info(prescriptionList);
        prescriptionList = prescriptionDAO.getPrescriptionByPatientID(19);

        MedicationDAO medicationDAO = new MedicationDAO();
        Medication medication = medicationDAO.getEntityByID(2);
        LOGGER.info(medication);
        List<Medication> medicationList = medicationDAO.getMedicationsByManufacturerID(2);
        LOGGER.info(medicationList);
    }
}