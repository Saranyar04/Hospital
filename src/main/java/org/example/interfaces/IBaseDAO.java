package org.example.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IBaseDAO<Entity> {

    void saveEntity(Entity entity);
    Entity getEntityByID(int id);
    void updateEntity(Entity entity);
    void removeEntityByID(int id);
    List<Entity> getAll();
}
