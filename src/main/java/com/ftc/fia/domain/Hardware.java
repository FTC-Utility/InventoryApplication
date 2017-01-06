package com.ftc.fia.domain;

import com.oracle.jrockit.jfr.EventDefinition;
import org.hamcrest.core.Is;

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
    @Id @GeneratedValue
    int id;

    String name;
    String description;

    @OneToOne
    Manufacturer manufacturer;

    @OneToOne
    Vendor vendor;

    @OneToOne
    HardwareStatus hardware_status;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Issue> issues = new ArrayList<>();

    @OneToOne
    EquipmentType equip_type;

    String serial_num;

    String tag_num;

    LocalDate purchase_date;

    @OneToMany
    @JoinTable(name = "position_hardware", joinColumns = @JoinColumn(name = "equip_type_id",
            referencedColumnName = "equip_type_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id"))
    private Collection<Position> positions = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Assigned> assigneds = new ArrayList<>();

    public Collection<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public Hardware(EquipmentType equip_type, String name, String description, Manufacturer manufacturer,
                    Vendor vendor, String serial_num, String tag_num, LocalDate purchase_date, HardwareStatus hardware_status) {
        this.equip_type = equip_type;
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.vendor = vendor;
        this.serial_num = serial_num;
        this.tag_num = tag_num;
        this.purchase_date = purchase_date;
        this.hardware_status = hardware_status;
    }


    public Hardware(String name, String description, String serial_num, String tag_num, LocalDate purchase_date) {
        this.name = name;
        this.description = description;
        this.serial_num = serial_num;
        this.tag_num = tag_num;
        this.purchase_date = purchase_date;
    }

    public HardwareStatus getHardware_status() {
        return hardware_status;
    }

    public void setHardware_status(HardwareStatus hardware_status) {
        this.hardware_status = hardware_status;
    }

    public Hardware() {
    }

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
                ", equip_type='" + equip_type + '\'' +
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
        if (getManufacturer() != null ? !getManufacturer().equals(hardware.getManufacturer()) : hardware.getManufacturer() != null)
            return false;
        if (getVendor() != null ? !getVendor().equals(hardware.getVendor()) : hardware.getVendor() != null)
            return false;
        if (getHardware_status() != null ? !getHardware_status().equals(hardware.getHardware_status()) : hardware.getHardware_status() != null)
            return false;
        if (getEquip_type() != null ? !getEquip_type().equals(hardware.getEquip_type()) : hardware.getEquip_type() != null)
            return false;
        if (getSerial_num() != null ? !getSerial_num().equals(hardware.getSerial_num()) : hardware.getSerial_num() != null)
            return false;
        if (getTag_num() != null ? !getTag_num().equals(hardware.getTag_num()) : hardware.getTag_num() != null)
            return false;
        return getPurchase_date() != null ? getPurchase_date().equals(hardware.getPurchase_date()) : hardware.getPurchase_date() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getQuip_type() != null ? getQuip_type().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getManufacturer() != null ? getManufacturer().hashCode() : 0);
        result = 31 * result + (getVendor() != null ? getVendor().hashCode() : 0);
        result = 31 * result + (getSerial_num() != null ? getSerial_num().hashCode() : 0);
        result = 31 * result + (getTag_num() != null ? getTag_num().hashCode() : 0);
        result = 31 * result + (getPurchase_date() != null ? getPurchase_date().hashCode() : 0);
        return result;
    }

    public void setPositions(Collection<Position> positions) {
        this.positions = positions;
    }

    public Collection<Assigned> getAssigneds() {
        return assigneds;
    }

    public void setAssigneds(Collection<Assigned> assigneds) {
        this.assigneds = assigneds;
    }

    public EquipmentType getEquip_type() {
        return equip_type;
    }

    public void setEquip_type(EquipmentType equip_type) {
        this.equip_type = equip_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EquipmentType getQuip_type() {
        return equip_type;
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

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

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
