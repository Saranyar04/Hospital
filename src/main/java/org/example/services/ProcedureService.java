package org.example.services;

import org.example.interfaces.IProcedureDAO;
import org.example.jdbc.dao.ProcedureDAO;
import org.example.models.hospital.Procedure;

import java.util.List;

public class ProcedureService implements IProcedureDAO {

    private final ProcedureDAO procedureDAO = new ProcedureDAO();

    @Override
    public void saveEntity(Procedure procedure) {
        procedureDAO.saveEntity(procedure);
    }

    @Override
    public Procedure getEntityByID(int id) {
        return procedureDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Procedure procedure) {
        procedureDAO.updateEntity(procedure);
    }

    @Override
    public void removeEntityByID(int id) {
        procedureDAO.removeEntityByID(id);
    }

    @Override
    public List<Procedure> getAll() {
        return procedureDAO.getAll();
    }

    @Override
    public Procedure getTopProcedure() {
        return procedureDAO.getTopProcedure();
    }
}
