package com.ftc.fia.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */
@Entity
@Table(name = "manufacturer")
public class Manufacturer {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name ="name")
    private String name;

    @Column(name = "cust_service")
    private String cust_service;

    @Column(name = "website")
    private String website;

    public Manufacturer() {
    }

    public Manufacturer(String name, String cust_service, String website) {
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
        if (!(o instanceof Manufacturer)) return false;
        Manufacturer that = (Manufacturer) o;
        return getId() == that.getId() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getCust_service(), that.getCust_service()) &&
                Objects.equals(getWebsite(), that.getWebsite());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCust_service(), getWebsite());
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cust_service='" + cust_service + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
