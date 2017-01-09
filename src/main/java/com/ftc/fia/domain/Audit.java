package com.ftc.fia.domain;

import javax.persistence.*;

/**
 * Created by Zelalem Belay on 1/4/2017.
 */

@Entity
@Table(name = "audit")
public class Audit
{
    @Id @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "license_type_id")
    LicenseType licenseType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "soft_license_id")
    SoftwareLicense softwareLicense;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assigned_id")
    Assigned assigned;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "issue_id")
    Issue issue;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "software_id")
    Software software;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hardware_id")
    Hardware hardware;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hardware_status_id")
    HardwareStatus hardwareStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor_id")
    Vendor vendor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacturer_id")
    Manufacturer manufacturer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    Location location;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipment_type_id")
    EquipmentType equipmentType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_hardware_id")
    PositionHardware positionHardware;

    public SoftwareLicense getSoftwareLicense() {
        return softwareLicense;
    }

    public void setSoftwareLicense(SoftwareLicense softwareLicense) {
        this.softwareLicense = softwareLicense;
    }

    public Audit() {
    }

    public PositionHardware getPositionHardware() {
        return positionHardware;
    }

    public void setPositionHardware(PositionHardware positionHardware) {
        this.positionHardware = positionHardware;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public HardwareStatus getHardwareStatus() {
        return hardwareStatus;
    }

    public void setHardwareStatus(HardwareStatus hardwareStatus) {
        this.hardwareStatus = hardwareStatus;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    public Hardware getHardware() {
        return hardware;
    }

    public void setHardware(Hardware hardware) {
        this.hardware = hardware;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LicenseType getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(LicenseType licenseType) {
        this.licenseType = licenseType;
    }

    public Assigned getAssigned() {
        return assigned;
    }

    public void setAssigned(Assigned assigned) {
        this.assigned = assigned;
    }
}
