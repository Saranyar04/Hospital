package org.example.services;

import org.example.interfaces.IProceduresDAO;
import org.example.jdbc.dao.ProceduresDAO;
import org.example.models.hospital.Procedures;

import java.util.List;

public class ProceduresService implements IProceduresDAO {

    private final ProceduresDAO proceduresDAO = new ProceduresDAO();

    @Override
    public void saveEntity(Procedures procedures) {
        proceduresDAO.saveEntity(procedures);
    }

    @Override
    public Procedures getEntityByID(int id) {
        return proceduresDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Procedures procedures) {
        proceduresDAO.updateEntity(procedures);
    }

    @Override
    public void removeEntityByID(int id) {
        proceduresDAO.removeEntityByID(id);
    }

    @Override
    public List<Procedures> getAll() {
        return proceduresDAO.getAll();
    }

    @Override
    public Procedures getTopProcedure() {
        return proceduresDAO.getTopProcedure();
    }
}
