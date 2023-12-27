package org.example.services;

import org.example.interfaces.IProceduresDAO;
import org.example.jdbc.dao.ProceduresDAO;
import org.example.models.hospital.Procedure;

import java.util.List;

public class ProceduresService implements IProceduresDAO {

    private final ProceduresDAO proceduresDAO = new ProceduresDAO();

    @Override
    public void saveEntity(Procedure procedure) {
        proceduresDAO.saveEntity(procedure);
    }

    @Override
    public Procedure getEntityByID(int id) {
        return proceduresDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Procedure procedure) {
        proceduresDAO.updateEntity(procedure);
    }

    @Override
    public void removeEntityByID(int id) {
        proceduresDAO.removeEntityByID(id);
    }

    @Override
    public List<Procedure> getAll() {
        return proceduresDAO.getAll();
    }

    @Override
    public Procedure getTopProcedure() {
        return proceduresDAO.getTopProcedure();
    }
}
