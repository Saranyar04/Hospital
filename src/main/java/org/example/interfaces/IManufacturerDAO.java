package org.example.interfaces;

import org.example.models.hospital.Manufacturer;

public interface IManufacturerDAO extends IBaseDAO<Manufacturer> {

    String getManufacturerAddressByName(String name);
}
