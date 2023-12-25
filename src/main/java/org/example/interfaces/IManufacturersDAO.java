package org.example.interfaces;

import org.example.models.hospital.Manufacturers;

public interface IManufacturersDAO extends IBaseDAO<Manufacturers> {

    String getManufacturerAddressByName(String name);
}
