package org.example.interfaces;

import org.example.models.hospital.Procedures;

public interface IProceduresDAO extends IBaseDAO<Procedures>{

    Procedures getTopProcedure();
}
