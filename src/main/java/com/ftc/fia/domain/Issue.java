package com.ftc.fia.domain;

import org.hibernate.annotations.Type;

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
    int id;

    SoftwareLicense softwareLicense;

    @Column(name = "request_date")
    @Type(type = "com.ftc.fia.util.LocalDateAttributeConverter")
    LocalDate request_date;

    @Column(name="resolve_date")
    @Type(type = "com.ftc.fia.util.LocalDateAttributeConverter")
    LocalDate resolveDate;

    String description;
    String resolution;

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

    @Id @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "soft_license_id")
    public SoftwareLicense getSoftwareLicense() {
        return softwareLicense;
    }

    public void setSoftwareLicense(SoftwareLicense softwareLicense) {
        this.softwareLicense = softwareLicense;
    }
}
