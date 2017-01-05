package com.ftc.fia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */
@Entity
@Table(name = "hardware_Status")
public class HardwareStatus {

    @Id
    @Column(name = "status")
    private String status;

    @Column(name = "description")
    private String description;

    public HardwareStatus() {
    }

    public HardwareStatus(String status, String description) {
        this.status = status;
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HardwareStatus)) return false;
        HardwareStatus that = (HardwareStatus) o;
        return Objects.equals(getStatus(), that.getStatus()) &&
                Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatus(), getDescription());
    }
}
