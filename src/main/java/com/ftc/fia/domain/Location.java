package com.ftc.fia.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Zelalem Belay on 1/9/2017.
 */
@Entity
@Table(name = "Location")
public class Location
{
    @Id @GeneratedValue
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "address1")
    private String address1;
    @Column(name = "address2")
    private String address2;
    @Column(name = "city")
    private String city;

    @Column(name = "state_code")
    private String stateCode;
    @Column(name = "zip")
    private String zip;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location", fetch = FetchType.LAZY)
    private Collection<Hardware> hardwares = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location", fetch = FetchType.LAZY)
    private Collection<Audit> audits = new HashSet<>();

    public Location(String name, String address1, String address2, String city, String stateCode, String zip) {
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.stateCode = stateCode;
        this.zip = zip;
    }

    public Location() {
    }

    public Collection<Audit> getAudits() {
        return audits;
    }

    public void setAudits(Collection<Audit> audits) {
        this.audits = audits;
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

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Collection<Hardware> getHardwares() {
        return hardwares;
    }

    public void setHardwares(Collection<Hardware> hardwares) {
        this.hardwares = hardwares;
    }
}
