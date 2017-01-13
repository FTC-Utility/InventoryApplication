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
@Table(name = "hardware_status")
public class HardwareStatus {

    @Id @GeneratedValue
    private int id;

    @Column(name = "description", nullable = false, columnDefinition = "VARCHAR(75)")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hardwareStatus")
    private Collection<Hardware> hardwares = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hardwareStatus", fetch = FetchType.LAZY)
    private Collection<Audit> audits = new HashSet<>();


    public HardwareStatus() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Hardware> getHardwares() {
        return hardwares;
    }

    public void setHardwares(Collection<Hardware> hardwares) {
        this.hardwares = hardwares;
    }

    public Collection<Audit> getAudits() {
        return audits;
    }

    public void setAudits(Collection<Audit> audits) {
        this.audits = audits;
    }

    public HardwareStatus(String description) {
        this.description = description;
    }

    public HardwareStatus(String description, Collection<Hardware> hardwares, Collection<Audit> audits) {
        this.description = description;
        this.hardwares = hardwares;
        this.audits = audits;
    }
}
