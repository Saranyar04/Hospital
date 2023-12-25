package org.example.services;

import org.example.interfaces.IManufacturersDAO;
import org.example.jdbc.dao.ManufacturersDAO;
import org.example.models.hospital.Manufacturers;

import java.util.List;

public class ManufacturersService implements IManufacturersDAO {

    private final ManufacturersDAO manufacturersDAO = new ManufacturersDAO();

    @Override
    public void saveEntity(Manufacturers manufacturers) {
        manufacturersDAO.saveEntity(manufacturers);
    }

    @Override
    public Manufacturers getEntityByID(int id) {
        return manufacturersDAO.getEntityByID(5);
    }

    @Override
    public void updateEntity(Manufacturers manufacturers) {
        manufacturersDAO.updateEntity(manufacturers);
    }

    @Override
    public void removeEntityByID(int id) {
        manufacturersDAO.removeEntityByID(id);
    }

    @Override
    public List<Manufacturers> getAll() {
        return manufacturersDAO.getAll();
    }

    @Override
    public String getManufacturerAddressByName(String name) {
        return manufacturersDAO.getManufacturerAddressByName(name);
    }
}
