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
@Table(name = "manufacturer")
public class Manufacturer {

    @Id  @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name ="name")
    private String name;

    @Column(name = "custService")
    private String custService;

    @Column(name = "website")
    private String website;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer", fetch = FetchType.LAZY)
    private Collection<Hardware> hardwares = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer", fetch = FetchType.LAZY)
    private Collection<Software> softwares = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer", fetch = FetchType.LAZY)
    private Collection<Audit> audits = new HashSet<>();

    public Manufacturer() {
    }

    public Manufacturer(String name, String cust_service, String website) {
        this.name = name;
        this.custService = cust_service;
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
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", custService='" + custService + '\'' +
                ", website='" + website + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manufacturer)) return false;

        Manufacturer that = (Manufacturer) o;

        if (getId() != that.getId()) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getCustService() != null ? !getCustService().equals(that.getCustService()) : that.getCustService() != null)
            return false;
        if (getWebsite() != null ? !getWebsite().equals(that.getWebsite()) : that.getWebsite() != null) return false;
        if (getHardwares() != null ? !getHardwares().equals(that.getHardwares()) : that.getHardwares() != null)
            return false;
        return getSoftwares() != null ? getSoftwares().equals(that.getSoftwares()) : that.getSoftwares() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getCustService() != null ? getCustService().hashCode() : 0);
        result = 31 * result + (getWebsite() != null ? getWebsite().hashCode() : 0);
        result = 31 * result + (getHardwares() != null ? getHardwares().hashCode() : 0);
        result = 31 * result + (getSoftwares() != null ? getSoftwares().hashCode() : 0);
        return result;
    }
}
