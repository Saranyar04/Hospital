package org.example.services;

import org.example.interfaces.IManufacturersDAO;
import org.example.jdbc.dao.ManufacturersDAO;
import org.example.models.hospital.Manufacturer;

import java.util.List;

public class ManufacturersService implements IManufacturersDAO {

    private final ManufacturersDAO manufacturersDAO = new ManufacturersDAO();

    @Override
    public void saveEntity(Manufacturer manufacturers) {
        manufacturersDAO.saveEntity(manufacturers);
    }

    @Override
    public Manufacturer getEntityByID(int id) {
        return manufacturersDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Manufacturer manufacturers) {
        manufacturersDAO.updateEntity(manufacturers);
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
