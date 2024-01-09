package org.example.factory;

import org.example.interfaces.IBaseDAO;
import org.example.mybatis.dao.*;

public class MyBatisDAOFactory implements IBaseDAOFactory{

    @Override
    public IBaseDAO getDAO(String tableName) {
        IBaseDAO table;
        switch (tableName) {
            case "appointments":
                table = new AppointmentDAO();
                break;
            case "departments":
                table = new DepartmentDAO();
                break;
            case "department_has_nurse":
                table = new DepartmentHasNurseDAO();
                break;
            case "examination_rooms":
                table = new ExaminationRoomDAO();
                break;
            case "manufacturers":
                table = new ManufacturerDAO();
                break;
            case "medications":
                table = new MedicationDAO();
                break;
            case "nurses":
                table = new NurseDAO();
                break;
            case "patients":
                table = new PatientDAO();
                break;
            case "physicians":
                table = new PhysicianDAO();
                break;
            case "positions":
                table = new PositionDAO();
            case "prescriptions":
                table = new PrescriptionDAO();
                break;
            case "procedures":
                table = new ProcedureDAO();
                break;
            case "specializations":
                table = new SpecializationDAO();
                break;
            default:
                table = null;
        }
        return table;
    }
}
