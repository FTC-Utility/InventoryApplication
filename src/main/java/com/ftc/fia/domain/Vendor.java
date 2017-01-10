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
@Table(name = "vendor")
public class Vendor {

    @Id  @GeneratedValue
    private int id;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(125)")
    private String name;

    @Column(name = "cust_service")
    private String custService;

    @Column(name = "website")
    private String website;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendor", fetch = FetchType.LAZY)
    private Collection<Hardware> hardwares = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendor", fetch = FetchType.LAZY)
    private Collection<Software> softwares = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendor", fetch = FetchType.LAZY)
    private Collection<Audit> audits = new HashSet<>();

    public Vendor() {
    }

    public Vendor(String name, String custService, String website) {
        this.name = name;
        this.custService = custService;
        this.website = website;
    }

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

    public String getCustService() {
        return custService;
    }

    public void setCustService(String custService) {
        this.custService = custService;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Collection<Hardware> getHardwares() {
        return hardwares;
    }

    public void setHardwares(Collection<Hardware> hardwares) {
        this.hardwares = hardwares;
    }

    public Collection<Software> getSoftwares() {
        return softwares;
    }

    public void setSoftwares(Collection<Software> softwares) {
        this.softwares = softwares;
    }

    public Collection<Audit> getAudits() {
        return audits;
    }

    public void setAudits(Collection<Audit> audits) {
        this.audits = audits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vendor)) return false;
        Vendor vendor = (Vendor) o;
        return getId() == vendor.getId() &&
                Objects.equals(getName(), vendor.getName()) &&
                Objects.equals(getCustService(), vendor.getCustService()) &&
                Objects.equals(getWebsite(), vendor.getWebsite());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCustService(), getWebsite());
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", custService='" + custService + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
