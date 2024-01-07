package org.example.factory;

import org.example.interfaces.IBaseDAO;

public interface IBaseDAOFactory {

    IBaseDAO getDAO(String tableName);
}
