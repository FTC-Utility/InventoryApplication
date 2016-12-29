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
@Table(name ="license_Type")
public class License_Type {

    @Id
    private String type;

    @Column(name = "description")
    private String description;

    public License_Type() {
    }

    public License_Type(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        if (!(o instanceof License_Type)) return false;
        License_Type that = (License_Type) o;
        return Objects.equals(getType(), that.getType()) &&
                Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getDescription());
    }

    @Override
    public String toString() {
        return "License_Type{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
