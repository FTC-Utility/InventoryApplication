package com.ftc.fia.domain;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Zelalem Belay on 1/5/2017.
 */

@Entity
@Table(name = "assigned")
public class Assigned
{
    @Id @GeneratedValue
    int id;

    @ManyToOne
    @JoinColumn(name = "soft_license_id")
    SoftwareLicense softwareLicense;

    LocalDate assigned;

    LocalDate unassigned;

    public Assigned(LocalDate assigned, LocalDate unassigned) {
        this.assigned = assigned;
        this.unassigned = unassigned;
    }

    public Assigned() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
