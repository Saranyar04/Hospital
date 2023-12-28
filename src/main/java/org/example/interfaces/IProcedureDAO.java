package org.example.interfaces;

import org.example.models.hospital.Procedure;

public interface IProceduresDAO extends IBaseDAO<Procedure>{

    Procedure getTopProcedure();
}
