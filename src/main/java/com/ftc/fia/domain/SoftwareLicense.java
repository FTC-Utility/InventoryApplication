package com.ftc.fia.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Zelalem Belay on 1/4/2017.
 */

@Entity
@Table (name = "software_license")
public class SoftwareLicense
{
    private int id;

    private Software software;

    private String licenceNumber;

    private LicenseType licenseType;

    private int maxUsers;

    @Type(type = "com.ftc.fia.util.LocalDateAttributeConverter")
    private LocalDate expirationDate;

    private Collection<Assigned> assigneds = new HashSet<>();

    private Collection<Issue> issues = new HashSet<>();

    private Collection<Audit> audits = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "softwareLicense")
    public Collection<Audit> getAudits() {
        return audits;
    }

    public void setAudits(Collection<Audit> audits) {
        this.audits = audits;
    }

    public SoftwareLicense() {
    }

    public SoftwareLicense(String licenceNumber, int maxUsers, LocalDate expirationDate) {
        this.licenceNumber = licenceNumber;
        this.maxUsers = maxUsers;
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "SoftwareLicense{" +
                "id=" + id +
                ", software=" + software +
                ", licenceNumber='" + licenceNumber + '\'' +
                ", licenseType=" + licenseType +
                ", maxUsers=" + maxUsers +
                ", expirationDate=" + expirationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SoftwareLicense)) return false;

        SoftwareLicense that = (SoftwareLicense) o;

        if (getId() != that.getId()) return false;
        if (getMaxUsers() != that.getMaxUsers()) return false;
        if (getSoftware() != null ? !getSoftware().equals(that.getSoftware()) : that.getSoftware() != null)
            return false;
        if (getLicenceNumber() != null ? !getLicenceNumber().equals(that.getLicenceNumber()) : that.getLicenceNumber() != null)
            return false;
        if (getLicenseType() != null ? !getLicenseType().equals(that.getLicenseType()) : that.getLicenseType() != null)
            return false;
        return getExpirationDate() != null ? getExpirationDate().equals(that.getExpirationDate()) : that.getExpirationDate() == null;
    }


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "softwareLicense", fetch = FetchType.LAZY)
    public Collection<Assigned> getAssigneds() {
        return assigneds;
    }

    public void setAssigneds(Collection<Assigned> assigneds) {
        this.assigneds = assigneds;
    }

    @OneToMany(mappedBy = "softwareLicense", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Collection<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Collection<Issue> issues) {
        this.issues = issues;
    }

    @Id @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "software_id", foreignKey = @ForeignKey(name = "FkSoftLicense_SoftwareId"), nullable = false)
    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    @Column(name = "license_num", columnDefinition = "VARCHAR(45) default 'Not Applicable'", nullable = false)
    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "license_type_id", foreignKey = @ForeignKey(name = "FkSoftLicense_LicenseTypeID"), nullable = false)
    public LicenseType getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(LicenseType licenseType) {
        this.licenseType = licenseType;
    }

    @Column(name = "max_users", nullable = false, columnDefinition = "INT(11) default '1'")
    public int getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(int maxUsers) {
        this.maxUsers = maxUsers;
    }

    @Column(name = "expiration_date")
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
