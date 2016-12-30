package com.ftc.fia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/30/2016.
 */
@Entity
@Table(name ="token_type")
public class TokeType {

    @Id
    private String type;

    @Column(name = "description")
    private String description;

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

    public TokeType() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TokeType)) return false;
        TokeType tokeType = (TokeType) o;
        return Objects.equals(getType(), tokeType.getType()) &&
                Objects.equals(getDescription(), tokeType.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getDescription());
    }

    @Override
    public String toString() {
        return "TokeType{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
