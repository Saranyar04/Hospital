package org.example.models;

import org.example.models.persons.Nurse;

import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "hospital")
@XmlType(propOrder = {"appointmentId", "appointmentStartTime", "appointmentEndTime", "departmentID", "departmentName", "departmentNursesList", "examinationRoomNo",
                        "roomType", "manufacturerID", "manufacturerName", "manufacturerAddress", "medicationID", "medicationName", "medicationDetails",
                        "amount", "prescriptionID", "prescriptionDate", "procedureID", "procedureName", "procedureCost", "procedureDescription", "nurseID",
                        "nurseFirstName", "nurseLastName", "patientID", "patientFirstName", "patientLastName", "patientDateOfBirth", "patientAddress",
                        "physicianID", "physicianFirstName", "physicianLastName", "physicianAddress", "positionID", "positionName", "specializationID", "specializationName"})

public class Hospital {

    private int appointmentID;
    private String appointmentStartTime;
    private String appointmentEndTime;
    private int departmentID;
    private String departmentName;
    private List<Nurse> departmentNursesList;
    private int examinationRoomNo;
    private String roomType;
    private int manufacturerID;
    private String manufacturerName;
    private String manufacturerAddress;
    private int medicationID;
    private String medicationName;
    private String medicationDetails;
    private double amount;
    private int prescriptionID;
    private Date prescriptionDate;
    private int procedureID;
    private String procedureName;
    private Double procedureCost;
    private String procedureDescription;
    private int nurseID;
    private String nurseFirstName;
    private String nurseLastName;
    private int patientID;
    private String patientFirstName;
    private String patientLastName;
    private Date patientDateOfBirth;
    private String patientAddress;
    private int physicianID;
    private String physicianFirstName;
    private String physicianLastName;
    private String physicianAddress;
    private int positionID;
    private String positionName;
    private int specializationID;
    private String specializationName;

    public Hospital(int appointmentID, String appointmentStartTime, String appointmentEndTime, int departmentID, String departmentName, List<Nurse> departmentNursesList, int examinationRoomNo, String roomType, int manufacturerID, String manufacturerName, String manufacturerAddress, int medicationID, String medicationName, String medicationDetails, double amount, int prescriptionID, Date prescriptionDate, int procedureID, String procedureName, Double procedureCost, String procedureDescription, int nurseID, String nurseFirstName, String nurseLastName, int patientID, String patientFirstName, String patientLastName, Date patientDateOfBirth, String patientAddress, int physicianID, String physicianFirstName, String physicianLastName, String physicianAddress, int positionID, String positionName, int specializationID, String specializationName) {
        this.appointmentID = appointmentID;
        this.appointmentStartTime = appointmentStartTime;
        this.appointmentEndTime = appointmentEndTime;
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.departmentNursesList = departmentNursesList;
        this.examinationRoomNo = examinationRoomNo;
        this.roomType = roomType;
        this.manufacturerID = manufacturerID;
        this.manufacturerName = manufacturerName;
        this.manufacturerAddress = manufacturerAddress;
        this.medicationID = medicationID;
        this.medicationName = medicationName;
        this.medicationDetails = medicationDetails;
        this.amount = amount;
        this.prescriptionID = prescriptionID;
        this.prescriptionDate = prescriptionDate;
        this.procedureID = procedureID;
        this.procedureName = procedureName;
        this.procedureCost = procedureCost;
        this.procedureDescription = procedureDescription;
        this.nurseID = nurseID;
        this.nurseFirstName = nurseFirstName;
        this.nurseLastName = nurseLastName;
        this.patientID = patientID;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.patientDateOfBirth = patientDateOfBirth;
        this.patientAddress = patientAddress;
        this.physicianID = physicianID;
        this.physicianFirstName = physicianFirstName;
        this.physicianLastName = physicianLastName;
        this.physicianAddress = physicianAddress;
        this.positionID = positionID;
        this.positionName = positionName;
        this.specializationID = specializationID;
        this.specializationName = specializationName;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getAppointmentStartTime() {
        return appointmentStartTime;
    }

    public void setAppointmentStartTime(String appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
    }

    public String getAppointmentEndTime() {
        return appointmentEndTime;
    }

    public void setAppointmentEndTime(String appointmentEndTime) {
        this.appointmentEndTime = appointmentEndTime;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Nurse> getDepartmentNursesList() {
        return departmentNursesList;
    }

    public void setDepartmentNursesList(List<Nurse> departmentNursesList) {
        this.departmentNursesList = departmentNursesList;
    }

    public int getExaminationRoomNo() {
        return examinationRoomNo;
    }

    public void setExaminationRoomNo(int examinationRoomNo) {
        this.examinationRoomNo = examinationRoomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getManufacturerID() {
        return manufacturerID;
    }

    public void setManufacturerID(int manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerAddress() {
        return manufacturerAddress;
    }

    public void setManufacturerAddress(String manufacturerAddress) {
        this.manufacturerAddress = manufacturerAddress;
    }

    public int getMedicationID() {
        return medicationID;
    }

    public void setMedicationID(int medicationID) {
        this.medicationID = medicationID;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getMedicationDetails() {
        return medicationDetails;
    }

    public void setMedicationDetails(String medicationDetails) {
        this.medicationDetails = medicationDetails;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public Date getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(Date prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public int getProcedureID() {
        return procedureID;
    }

    public void setProcedureID(int procedureID) {
        this.procedureID = procedureID;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public Double getProcedureCost() {
        return procedureCost;
    }

    public void setProcedureCost(Double procedureCost) {
        this.procedureCost = procedureCost;
    }

    public String getProcedureDescription() {
        return procedureDescription;
    }

    public void setProcedureDescription(String procedureDescription) {
        this.procedureDescription = procedureDescription;
    }

    public int getNurseID() {
        return nurseID;
    }

    public void setNurseID(int nurseID) {
        this.nurseID = nurseID;
    }

    public String getNurseFirstName() {
        return nurseFirstName;
    }

    public void setNurseFirstName(String nurseFirstName) {
        this.nurseFirstName = nurseFirstName;
    }

    public String getNurseLastName() {
        return nurseLastName;
    }

    public void setNurseLastName(String nurseLastName) {
        this.nurseLastName = nurseLastName;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public Date getPatientDateOfBirth() {
        return patientDateOfBirth;
    }

    public void setPatientDateOfBirth(Date patientDateOfBirth) {
        this.patientDateOfBirth = patientDateOfBirth;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public int getPhysicianID() {
        return physicianID;
    }

    public void setPhysicianID(int physicianID) {
        this.physicianID = physicianID;
    }

    public String getPhysicianFirstName() {
        return physicianFirstName;
    }

    public void setPhysicianFirstName(String physicianFirstName) {
        this.physicianFirstName = physicianFirstName;
    }

    public String getPhysicianLastName() {
        return physicianLastName;
    }

    public void setPhysicianLastName(String physicianLastName) {
        this.physicianLastName = physicianLastName;
    }

    public String getPhysicianAddress() {
        return physicianAddress;
    }

    public void setPhysicianAddress(String physicianAddress) {
        this.physicianAddress = physicianAddress;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public int getSpecializationID() {
        return specializationID;
    }

    public void setSpecializationID(int specializationID) {
        this.specializationID = specializationID;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }
}
