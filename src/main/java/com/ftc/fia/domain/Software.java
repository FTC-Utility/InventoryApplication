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

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "software", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<SoftwareLicense> softwareLicenses = new HashSet<>();

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
