package com.ftc.fia.domain;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/29/2016.
 */
@Entity
@Table(name = "software")
public class Software {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(75)")
    private String name;

    @OneToMany(mappedBy = "software", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<SoftwareLicense> softwareLicenses = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "software", fetch = FetchType.LAZY)
    private Collection<Audit> audits = new HashSet<>();

    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkSoftware_ManufacturerId"), nullable = false)
    Manufacturer manufacturer;

    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkSoftware_VendorFk"), nullable = false)
    Vendor vendor;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "software", fetch = FetchType.LAZY)
    private Collection<PositionSoftware> positionSoftwares = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Software() {
    }

    public Collection<Audit> getAudits() {
        return audits;
    }

    public void setAudits(Collection<Audit> audits) {
        this.audits = audits;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Collection<PositionSoftware> getPositionSoftwares() {
        return positionSoftwares;
    }

    public void setPositionSoftwares(Collection<PositionSoftware> positionSoftwares) {
        this.positionSoftwares = positionSoftwares;
    }

    public Collection<SoftwareLicense> getSoftwareLicenses() {
        return softwareLicenses;
    }

    public void setSoftwareLicenses(Collection<SoftwareLicense> softwareLicenses) {
        this.softwareLicenses = softwareLicenses;
    }

    public Software(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Software)) return false;
        Software software = (Software) o;
        return getId() == software.getId() &&
                Objects.equals(getName(), software.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "Software{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
