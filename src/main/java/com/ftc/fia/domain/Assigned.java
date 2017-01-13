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

    private SoftwareLicense softwareLicense;

    @Type(type = "com.ftc.fia.util.LocalDateAttributeConverter")
    private LocalDate assignedDate;

    @Type(type = "com.ftc.fia.util.LocalDateAttributeConverter")
    private LocalDate unassignedDate;

    private Collection<Audit> audits = new HashSet<>();

    private Hardware hardware;

    public Assigned(LocalDate assignedDate, LocalDate unassignedDate) {
        this.assignedDate = assignedDate;
        this.unassignedDate = unassignedDate;
    }

    public Assigned(int id, SoftwareLicense softwareLicense, LocalDate assignedDate, LocalDate unassignedDate, Collection<Audit> audits, Hardware hardware, User user) {
        this.id = id;
        this.softwareLicense = softwareLicense;
        this.assignedDate = assignedDate;
        this.unassignedDate = unassignedDate;
        this.audits = audits;
        this.hardware = hardware;
        this.user = user;
    }

    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assigned", fetch = FetchType.LAZY)
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
    @JoinColumn(name = "hardware_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkAssigned_HardwareID"))
    public Hardware getHardware() {
        return hardware;
    }

    public void setHardware(Hardware hardware) {
        this.hardware = hardware;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "soft_license_id", foreignKey = @ForeignKey(name = "FkAssigned_SoftLicenseID"))
    public SoftwareLicense getSoftwareLicense() {
        return softwareLicense;
    }

    public void setSoftwareLicense(SoftwareLicense softwareLicense) {
        this.softwareLicense = softwareLicense;
    }

    @Column(name = "assigned_date", nullable = false)
    public LocalDate getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(LocalDate assignedDate) {
        this.assignedDate = assignedDate;
    }

    @Column(name = "unassigned_date")
    public LocalDate getUnassignedDate() {
        return unassignedDate;
    }

    public void setUnassignedDate(LocalDate unassigned) {
        this.unassignedDate = unassignedDate;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FkAssigned_UserID"))
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Assigned{" +
                "id=" + id +
                ", softwareLicense=" + softwareLicense +
                ", assignedDate=" + assignedDate +
                ", unassignedDate=" + unassignedDate +
                ", audits=" + audits +
                ", hardware=" + this.getHardware()  +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Assigned)) return false;

        Assigned assigned = (Assigned) o;

        if (getId() != assigned.getId()) return false;
        if (getSoftwareLicense() != null ? !getSoftwareLicense().equals(assigned.getSoftwareLicense()) : assigned.getSoftwareLicense() != null)
            return false;
        if (getAssignedDate() != null ? !getAssignedDate().equals(assigned.getAssignedDate()) : assigned.getAssignedDate() != null)
            return false;
        if (getUnassignedDate() != null ? !getUnassignedDate().equals(assigned.getUnassignedDate()) : assigned.getUnassignedDate() != null)
            return false;
        if (getAudits() != null ? !getAudits().equals(assigned.getAudits()) : assigned.getAudits() != null)
            return false;
        if (getHardware() != null ? !getHardware().equals(assigned.getHardware()) : assigned.getHardware() != null)
            return false;
        return getUser() != null ? getUser().equals(assigned.getUser()) : assigned.getUser() == null;
    }

}
