package org.example.models.hospital;

public class Manufacturer {

    private int manufacturerID;
    private String name;
    private String address;

    public Manufacturer() {
    }

    public Manufacturer(int manufacturerID, String name, String address) {
        this.manufacturerID = manufacturerID;
        this.name = name;
        this.address = address;
    }

    public int getManufacturerID() {
        return manufacturerID;
    }

    public void setManufacturerID(int manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "manufacturerID=" + manufacturerID +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
