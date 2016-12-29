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
@Table(name = "position")
public class Position {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Position() {
    }

    public Position(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(o instanceof Position)) return false;
        Position positions = (Position) o;
        return Objects.equals(getName(), positions.getName()) &&
                Objects.equals(getDescription(), positions.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription());
    }

    @Override
    public String toString() {
        return "Position{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
