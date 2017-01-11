package com.ftc.fia.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */

@Entity
@Table(name = "audit_event")
public class AuditEvent {

    @Id
    private int id;

    @Column(name = "description", nullable = false, columnDefinition = "VARCHAR(75)")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "auditEvent")
    private Collection<Audit> audits = new ArrayList<>();

    public AuditEvent() {
    }

    public AuditEvent(int id, String description) {
        this.id = id;
        this.description = description;
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

    public Collection<Audit> getAudits() {
        return audits;
    }

    public void setAudits(Collection<Audit> audits) {
        this.audits = audits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuditEvent)) return false;
        AuditEvent that = (AuditEvent) o;
        return getId() == that.getId() &&
                Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription());
    }

    @Override
    public String toString() {
        return "AuditEvent{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
