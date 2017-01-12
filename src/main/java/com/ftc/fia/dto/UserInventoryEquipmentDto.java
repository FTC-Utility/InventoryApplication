package com.ftc.fia.dto;

/**
 * Created by FPerez on 1/10/2017.
 */
public class UserInventoryEquipmentDto {

    private String serialNumber;
    private String description;
    private String location;
    private String condition;
    private String vendor;
    private String assignedTo;
    private String defective;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getDefective() {
        return defective;
    }

    public void setDefective(String defective) {
        this.defective = defective;
    }
}
