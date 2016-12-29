package com.ftc.fia.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */
@Entity
@Table(name = "vendor")
public class Vendor {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "cust_service")
    private String cust_service;

    @Column(name = "website")
    private String website;

    public Vendor() {
    }

    public Vendor(String name, String cust_service, String website) {
        this.name = name;
        this.cust_service = cust_service;
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

    public String getCust_service() {
        return cust_service;
    }

    public void setCust_service(String cust_service) {
        this.cust_service = cust_service;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vendor)) return false;
        Vendor vendor = (Vendor) o;
        return getId() == vendor.getId() &&
                Objects.equals(getName(), vendor.getName()) &&
                Objects.equals(getCust_service(), vendor.getCust_service()) &&
                Objects.equals(getWebsite(), vendor.getWebsite());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCust_service(), getWebsite());
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cust_service='" + cust_service + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
