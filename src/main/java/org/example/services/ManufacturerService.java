package org.example.services;

import org.example.interfaces.IManufacturerDAO;
import org.example.jdbc.dao.ManufacturerDAO;
import org.example.models.hospital.Manufacturer;

import java.util.List;

public class ManufacturerService implements IManufacturerDAO {

    private final ManufacturerDAO manufacturerDAO = new ManufacturerDAO();

    @Override
    public void saveEntity(Manufacturer manufacturer) {
        manufacturerDAO.saveEntity(manufacturer);
    }

    @Override
    public Manufacturer getEntityByID(int id) {
        return manufacturerDAO.getEntityByID(id);
    }

    @Override
    public void updateEntity(Manufacturer manufacturer) {
        manufacturerDAO.updateEntity(manufacturer);
    }

    @Override
    public void removeEntityByID(int id) {
        manufacturerDAO.removeEntityByID(id);
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerDAO.getAll();
    }

    @Override
    public String getManufacturerAddressByName(String name) {
        return manufacturerDAO.getManufacturerAddressByName(name);
    }
}
