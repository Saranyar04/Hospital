package org.example.services;

import org.example.interfaces.IManufacturersDAO;
import org.example.jdbc.dao.ManufacturersDAO;
import org.example.models.hospital.Manufacturer;

import java.util.List;

public class ManufacturersService implements IManufacturersDAO {

    private final ManufacturersDAO manufacturersDAO = new ManufacturersDAO();

    @Override
    public void saveEntity(Manufacturer manufacturer) {
        manufacturersDAO.saveEntity(manufacturer);
    }

    @Override
    public Manufacturer getEntityByID(int id) {
        return manufacturersDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Manufacturer manufacturer) {
        manufacturersDAO.updateEntity(manufacturer);
    }

    @Override
    public void removeEntityByID(int id) {
        manufacturersDAO.removeEntityByID(id);
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturersDAO.getAll();
    }

    @Override
    public String getManufacturerAddressByName(String name) {
        return manufacturersDAO.getManufacturerAddressByName(name);
    }
}
