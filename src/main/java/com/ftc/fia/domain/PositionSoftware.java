package com.ftc.fia.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Zelalem Belay on 1/3/2017.
 */

@Entity
@Table(name = "position_software")
public class PositionSoftware
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FkPosSoftware_PositionID"))
    private Position position;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "software_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FkPosSoftware_SoftwareID"))
    private Software software;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "positionSoftware")
    private Collection<Audit> audits = new ArrayList<>();

    public PositionSoftware() {
    }



    public Collection<Audit> getAudits() {
        return audits;
    }

    public void setAudits(Collection<Audit> audits) {
        this.audits = audits;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
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
        if (!(o instanceof PositionSoftware)) return false;

        PositionSoftware that = (PositionSoftware) o;

        if (getId() != that.getId()) return false;
        if (getPosition() != null ? !getPosition().equals(that.getPosition()) : that.getPosition() != null)
            return false;
        if (getSoftware() != null ? !getSoftware().equals(that.getSoftware()) : that.getSoftware() != null)
            return false;
        return getAudits() != null ? getAudits().equals(that.getAudits()) : that.getAudits() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getPosition() != null ? getPosition().hashCode() : 0);
        result = 31 * result + (getSoftware() != null ? getSoftware().hashCode() : 0);
        result = 31 * result + (getAudits() != null ? getAudits().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PositionSoftware{" +
                "id=" + id +
                ", position=" + position +
                ", software=" + software +
                ", audits=" + audits +
                '}';
    }
}
