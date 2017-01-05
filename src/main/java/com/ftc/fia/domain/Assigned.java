package com.ftc.fia.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Zelalem Belay on 1/5/2017.
 */

@Entity
@Table(name = "assigned")
public class Assigned
{
    int id;

    SoftwareLicense softwareLicense;

    @Type(type = "com.ftc.fia.util.LocalDateAttributeConverter")
    LocalDate assigned;

    @Type(type = "com.ftc.fia.util.LocalDateAttributeConverter")
    LocalDate unassigned;

    Collection<Audit> audits = new HashSet<>();

    public Assigned(LocalDate assigned, LocalDate unassigned) {
        this.assigned = assigned;
        this.unassigned = unassigned;
    }


    @OneToMany(cascade = CascadeType.ALL)
    public Collection<Audit> getAudits() {
        return audits;
    }

    public void setAudits(Collection<Audit> audits) {
        this.audits = audits;
    }

    public Assigned() {
    }

    @Id @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public SoftwareLicense getSoftwareLicense() {
        return softwareLicense;
    }

    public void setSoftwareLicense(SoftwareLicense softwareLicense) {
        this.softwareLicense = softwareLicense;
    }

    public LocalDate getAssigned() {
        return assigned;
    }

    public void setAssigned(LocalDate assigned) {
        this.assigned = assigned;
    }

    public LocalDate getUnassigned() {
        return unassigned;
    }

    public void setUnassigned(LocalDate unassigned) {
        this.unassigned = unassigned;
    }
}
