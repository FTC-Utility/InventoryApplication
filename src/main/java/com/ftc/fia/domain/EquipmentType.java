package com.ftc.fia.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */
@Entity
@Table(name = "equipment_Type")
public class EquipmentType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipmentType", fetch = FetchType.LAZY)
    private Collection<Hardware> hardwares = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipmentType", fetch = FetchType.LAZY)
    private Collection<Audit> audits = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipmentType", fetch = FetchType.LAZY)
    private Collection<PositionHardware> positionHardwares = new ArrayList<>();

    public EquipmentType() {
    }

    public EquipmentType(String name) {
        this.name = name;
    }

    public EquipmentType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Collection<Audit> getAudits() {
        return audits;
    }

    public void setAudits(Collection<Audit> audits) {
        this.audits = audits;
    }

    public Collection<PositionHardware> getPositionHardwares() {
        return positionHardwares;
    }

    public void setPositionHardwares(Collection<PositionHardware> positionHardwares) {
        this.positionHardwares = positionHardwares;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Hardware> getHardwares() {
        return hardwares;
    }

    public void setHardwares(Collection<Hardware> hardwares) {
        this.hardwares = hardwares;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquipmentType)) return false;
        EquipmentType that = (EquipmentType) o;
        return getId() == that.getId() &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "EquipmentType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
