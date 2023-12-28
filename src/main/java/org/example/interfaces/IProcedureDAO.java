package org.example.interfaces;

import org.example.models.hospital.Procedure;

public interface IProcedureDAO extends IBaseDAO<Procedure>{

    Procedure getTopProcedure();
}
