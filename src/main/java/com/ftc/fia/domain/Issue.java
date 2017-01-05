package com.ftc.fia.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Zelalem Belay on 1/4/2017.
 */
@Entity
@Table(name = "issue")
public class Issue
{
    @Id @GeneratedValue
    int id;

    @ManyToOne
    @JoinColumn(name = "soft_license_id")
    SoftwareLicense softwareLicense;

    @Column(name = "request_date")
    LocalDate request_date;

    @Column(name="resolveDate")
    LocalDate resolveDate;

    String description;
    String resolution;

    @OneToMany
    Collection<SoftwareLicense> softwareLicenses = new ArrayList<>();

    public LocalDate getRequest_date() {
        return request_date;
    }

    public void setRequest_date(LocalDate request_date) {
        this.request_date = request_date;
    }

    public LocalDate getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(LocalDate resolveDate) {
        this.resolveDate = resolveDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Issue() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SoftwareLicense getSoftwareLicense() {
        return softwareLicense;
    }

    public void setSoftwareLicense(SoftwareLicense softwareLicense) {
        this.softwareLicense = softwareLicense;
    }
}
