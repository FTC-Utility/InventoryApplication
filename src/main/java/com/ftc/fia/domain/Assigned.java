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
    @JoinColumn(name = "software_license_id", foreignKey = @ForeignKey(name = "FkAssigned_SoftLicenseID"))
    public SoftwareLicense getSoftwareLicense() {
        return softwareLicense;
    }

    public void setSoftwareLicense(SoftwareLicense softwareLicense) {
        this.softwareLicense = softwareLicense;
    }

    @Column(name = "assigned_date")
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
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkAssigned_UserID"))
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
