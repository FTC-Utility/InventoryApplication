package com.ftc.fia.domain;

import javax.persistence.*;

/**
 * Created by Zelalem Belay on 1/4/2017.
 */

@Entity
@Table(name = "audit")
public class Audit
{
    @Id @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "license_type_id")
    LicenseType licenseType;

    @ManyToOne
    @JoinColumn(name = "soft_license_id")
    SoftwareLicense softwareLicense;

    public SoftwareLicense getSoftwareLicense() {
        return softwareLicense;
    }

    public void setSoftwareLicense(SoftwareLicense softwareLicense) {
        this.softwareLicense = softwareLicense;
    }

    public Audit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LicenseType getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(LicenseType licenseType) {
        this.licenseType = licenseType;
    }

}
