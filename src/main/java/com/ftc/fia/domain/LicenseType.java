package com.ftc.fia.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */

@Entity
@Table(name ="license_Type")
public class LicenseType {

    @Id @GeneratedValue
    private int id;

    @Column(name = "description", nullable = false, columnDefinition = "VARCHAR(75)")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "licenseType", fetch = FetchType.LAZY)
    private Collection<SoftwareLicense> softwareLicences = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "licenseType", fetch = FetchType.EAGER)
    private Collection<Audit> audits = new HashSet<>();

    public LicenseType() {
    }

    public LicenseType(String description, Collection<SoftwareLicense> softwareLicences) {
        this.description = description;
        this.softwareLicences = softwareLicences;
    }

    public LicenseType(String description) {
        this.description = description;
    }

    public Collection<Audit> getAudits() {
        return audits;
    }

    public void setAudits(Collection<Audit> audit) {
        this.audits = audits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<SoftwareLicense> getSoftwareLicences() {
        return softwareLicences;
    }

    public void setSoftwareLicences(Collection<SoftwareLicense> softwareLicences) {
        this.softwareLicences = softwareLicences;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LicenseType)) return false;
        LicenseType that = (LicenseType) o;
        return Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription());
    }

    @Override
    public String toString() {
        return "LicenseType{" +
                ", description='" + description + '\'' +
                '}';
    }
}
