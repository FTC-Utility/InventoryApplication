package com.ftc.fia.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Zelalem Belay on 12/30/2016.
 */

@Entity
@Table(name="hardware")
public class Hardware implements Serializable
{
    private int id;

    private String name;
    private String description;

    private Location location;

    private EquipmentType equipmentType;

    private Manufacturer manufacturer;

    private Vendor vendor;

    private HardwareStatus hardwareStatus;

    private Collection<Issue> issues = new ArrayList<>();

    private Collection<Audit> audits = new ArrayList<>();

    private String serial_num;

    private String tag_num;

    @Type(type = "com.ftc.fia.util.LocalDateAttributeConverter")
    private LocalDate purchase_date;

    private Collection<Position> positions = new ArrayList<>();

    private Collection<Assigned> assigneds = new ArrayList<>();

    @OneToMany
    @JoinTable(name = "position_hardware", joinColumns = @JoinColumn(name = "equipment_type_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id"))
    public Collection<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public Hardware(String name, String description, String serial_num, String tag_num, LocalDate purchase_date) {
        this.name = name;
        this.description = description;
        this.serial_num = serial_num;
        this.tag_num = tag_num;
        this.purchase_date = purchase_date;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hardware", cascade = CascadeType.ALL)
    public Collection<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Collection<Issue> issues) {
        this.issues = issues;
    }

    @Override
    public String toString() {
        return "Hardware{" +
                "id=" + id +
                ", equip_type='" + equipmentType + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", manufacturer=" + manufacturer +
                ", vendor=" + vendor +
                ", serial_num='" + serial_num + '\'' +
                ", tag_num='" + tag_num + '\'' +
                ", purchase_date=" + purchase_date +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hardware)) return false;

        Hardware hardware = (Hardware) o;

        if (getId() != hardware.getId()) return false;
        if (getName() != null ? !getName().equals(hardware.getName()) : hardware.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(hardware.getDescription()) : hardware.getDescription() != null)
            return false;
        if (getLocation() != null ? !getLocation().equals(hardware.getLocation()) : hardware.getLocation() != null)
            return false;
        if (getEquipmentType() != null ? !getEquipmentType().equals(hardware.getEquipmentType()) : hardware.getEquipmentType() != null)
            return false;
        if (getManufacturer() != null ? !getManufacturer().equals(hardware.getManufacturer()) : hardware.getManufacturer() != null)
            return false;
        if (getVendor() != null ? !getVendor().equals(hardware.getVendor()) : hardware.getVendor() != null)
            return false;
        if (getHardwareStatus() != null ? !getHardwareStatus().equals(hardware.getHardwareStatus()) : hardware.getHardwareStatus() != null)
            return false;
        if (getIssues() != null ? !getIssues().equals(hardware.getIssues()) : hardware.getIssues() != null)
            return false;
        if (getAudits() != null ? !getAudits().equals(hardware.getAudits()) : hardware.getAudits() != null)
            return false;
        if (getSerial_num() != null ? !getSerial_num().equals(hardware.getSerial_num()) : hardware.getSerial_num() != null)
            return false;
        if (getTag_num() != null ? !getTag_num().equals(hardware.getTag_num()) : hardware.getTag_num() != null)
            return false;
        if (getPurchase_date() != null ? !getPurchase_date().equals(hardware.getPurchase_date()) : hardware.getPurchase_date() != null)
            return false;
        if (getPositions() != null ? !getPositions().equals(hardware.getPositions()) : hardware.getPositions() != null)
            return false;
        return getAssigneds() != null ? getAssigneds().equals(hardware.getAssigneds()) : hardware.getAssigneds() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getLocation() != null ? getLocation().hashCode() : 0);
        result = 31 * result + (getEquipmentType() != null ? getEquipmentType().hashCode() : 0);
        result = 31 * result + (getManufacturer() != null ? getManufacturer().hashCode() : 0);
        result = 31 * result + (getVendor() != null ? getVendor().hashCode() : 0);
        result = 31 * result + (getHardwareStatus() != null ? getHardwareStatus().hashCode() : 0);
        result = 31 * result + (getIssues() != null ? getIssues().hashCode() : 0);
        result = 31 * result + (getAudits() != null ? getAudits().hashCode() : 0);
        result = 31 * result + (getSerial_num() != null ? getSerial_num().hashCode() : 0);
        result = 31 * result + (getTag_num() != null ? getTag_num().hashCode() : 0);
        result = 31 * result + (getPurchase_date() != null ? getPurchase_date().hashCode() : 0);
        result = 31 * result + (getPositions() != null ? getPositions().hashCode() : 0);
        result = 31 * result + (getAssigneds() != null ? getAssigneds().hashCode() : 0);
        return result;
    }

    @Id @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", foreignKey = @ForeignKey(name = "FkHardware_LocationID"))
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipment_type_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkHardware_EquipTypeID"))
    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "hardware_status_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkHardware_HardwareStatusID"))
    public HardwareStatus getHardwareStatus() {
        return hardwareStatus;
    }

    public void setHardwareStatus(HardwareStatus hardwareStatus) {
        this.hardwareStatus = hardwareStatus;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hardware", fetch = FetchType.LAZY)
    public Collection<Audit> getAudits() {
        return audits;
    }

    public void setAudits(Collection<Audit> audits) {
        this.audits = audits;
    }

    public void setPositions(Collection<Position> positions) {
        this.positions = positions;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hardware", fetch = FetchType.LAZY)
    public Collection<Assigned> getAssigneds() {
        return assigneds;
    }

    public void setAssigneds(Collection<Assigned> assigneds) {
        this.assigneds = assigneds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id",  foreignKey = @ForeignKey(name = "FkHardware_ManufacturerID"))
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", foreignKey = @ForeignKey(name = "FkHardware_VendorID"))
    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getSerial_num() {
        return serial_num;
    }

    public void setSerial_num(String serial_num) {
        this.serial_num = serial_num;
    }

    public String getTag_num() {
        return tag_num;
    }

    public void setTag_num(String tag_num) {
        this.tag_num = tag_num;
    }

    public LocalDate getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(LocalDate purchase_date) {
        this.purchase_date = purchase_date;
    }

}
