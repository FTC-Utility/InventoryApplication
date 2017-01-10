package com.ftc.fia.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Zelalem Belay on 1/4/2017.
 */
@Entity
@Table(name = "issue")
public class Issue
{
    private int id;

    private SoftwareLicense softwareLicense;

    private Hardware hardware;

    private Collection<Audit> audits = new ArrayList<>();

    private User requestor;

    private User resolvedBy;

    @Type(type = "com.ftc.fia.util.LocalDateAttributeConverter")
    private LocalDate requestDate;

    @Type(type = "com.ftc.fia.util.LocalDateAttributeConverter")
    private LocalDate resolveDate;

    private String description;
    private String resolution;

    public Issue(LocalDate requestDate, LocalDate resolveDate, String description, String resolution) {
        this.requestDate = requestDate;
        this.resolveDate = resolveDate;
        this.description = description;
        this.resolution = resolution;
    }

    public Issue(SoftwareLicense softwareLicense, Hardware hardware, Collection<Audit> audits, User requestor,
                 User resolvedBy, LocalDate requestDate, LocalDate resolveDate, String description, String resolution) {
        this.softwareLicense = softwareLicense;
        this.hardware = hardware;
        this.audits = audits;
        this.requestor = requestor;
        this.resolvedBy = resolvedBy;
        this.requestDate = requestDate;
        this.resolveDate = resolveDate;
        this.description = description;
        this.resolution = resolution;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "requestor",nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "Fk_IssueRequestUserID"))
    public User getRequestor() {
        return requestor;
    }

    public void setRequestor(User requestor) {
        this.requestor = requestor;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "resolved_by", referencedColumnName = "id", foreignKey = @ForeignKey(name = "Fk_IssueResolveUserID"))
    public User getResolvedBy() {
        return resolvedBy;
    }

    public void setResolvedBy(User resolvedBy) {
        this.resolvedBy = resolvedBy;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "hardware_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "Fk_IssueHardwareID"))
    public Hardware getHardware() {
        return hardware;
    }

    public void setHardware(Hardware hardware) {
        this.hardware = hardware;
    }

    @Column(name = "request_date", nullable = false)
    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    @Column(name="resolve_date")
    public LocalDate getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(LocalDate resolveDate) {
        this.resolveDate = resolveDate;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Issue() {
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "issue", fetch = FetchType.LAZY)
    public Collection<Audit> getAudits() {
        return audits;
    }

    public void setAudits(Collection<Audit> audits) {
        this.audits = audits;
    }


    @Id @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "soft_license_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "Fk_IssueSoftLicenseID"))
    public SoftwareLicense getSoftwareLicense() {
        return softwareLicense;
    }

    public void setSoftwareLicense(SoftwareLicense softwareLicense) {
        this.softwareLicense = softwareLicense;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", softwareLicense=" + softwareLicense +
                ", hardware=" + hardware +
                ", audits=" + audits +
                ", requestor=" + requestor +
                ", resolvedBy=" + resolvedBy +
                ", requestDate=" + requestDate +
                ", resolveDate=" + resolveDate +
                ", description='" + description + '\'' +
                ", resolution='" + resolution + '\'' +
                '}';
    }
}
