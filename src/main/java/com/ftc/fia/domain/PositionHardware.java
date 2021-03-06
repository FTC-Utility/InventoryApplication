package com.ftc.fia.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Zelalem Belay on 1/3/2017.
 */

@Entity
@Table(name = "position_hardware")
public class PositionHardware
{
    @Id @GeneratedValue
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FkPosHardware_PositionID"))
    private Position position;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipment_type_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FkPosHardware_EquipTypeID"))
    private EquipmentType equipmentType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "positionHardware", fetch = FetchType.LAZY)
    private Collection<Audit> audits = new ArrayList<>();

    @Column(name = "quantity", nullable = false, columnDefinition = "INT(11) default 1")
    private int quantity;

    public PositionHardware() {
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Collection<Audit> getAudits() {
        return audits;
    }

    public void setAudits(Collection<Audit> audits) {
        this.audits = audits;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public PositionHardware(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PositionHardware)) return false;

        PositionHardware that = (PositionHardware) o;

        if (getId() != that.getId()) return false;
        if (getQuantity() != that.getQuantity()) return false;
        if (getPosition() != null ? !getPosition().equals(that.getPosition()) : that.getPosition() != null)
            return false;
        if (getEquipmentType() != null ? !getEquipmentType().equals(that.getEquipmentType()) : that.getEquipmentType() != null)
            return false;
        return getAudits() != null ? getAudits().equals(that.getAudits()) : that.getAudits() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getPosition() != null ? getPosition().hashCode() : 0);
        result = 31 * result + (getEquipmentType() != null ? getEquipmentType().hashCode() : 0);
        result = 31 * result + (getAudits() != null ? getAudits().hashCode() : 0);
        result = 31 * result + getQuantity();
        return result;
    }


    @Override
    public String toString() {
        return "PositionHardware{" +
                "id=" + id +
                ", position=" + position +
                ", equipmentType=" + equipmentType +
                ", audits=" + audits +
                ", quantity=" + quantity +
                '}';
    }
}
