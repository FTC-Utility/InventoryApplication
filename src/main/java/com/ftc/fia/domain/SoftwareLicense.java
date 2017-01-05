package com.ftc.fia.domain;

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
    @Id @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "software_id")
    private Software software;

    private String licenceNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "license_type_id")
    private LicenseType licenseType;

    @Column(name = "max_users")
    private int maxUsers;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "softwareLicense", fetch = FetchType.LAZY)
    private Collection<Assigned> assigneds = new HashSet<>();

    @OneToMany(mappedBy = "softwareLicense")
    private Collection<Issue> issues = new HashSet<>();

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

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getSoftware() != null ? getSoftware().hashCode() : 0);
        result = 31 * result + (getLicenceNumber() != null ? getLicenceNumber().hashCode() : 0);
        result = 31 * result + (getLicenseType() != null ? getLicenseType().hashCode() : 0);
        result = 31 * result + getMaxUsers();
        result = 31 * result + (getExpirationDate() != null ? getExpirationDate().hashCode() : 0);
        return result;
    }

    public Collection<Assigned> getAssigneds() {
        return assigneds;
    }

    public void setAssigneds(Collection<Assigned> assigneds) {
        this.assigneds = assigneds;
    }

    public Collection<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Collection<Issue> issues) {
        this.issues = issues;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public LicenseType getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(LicenseType licenseType) {
        this.licenseType = licenseType;
    }

    public int getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(int maxUsers) {
        this.maxUsers = maxUsers;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
