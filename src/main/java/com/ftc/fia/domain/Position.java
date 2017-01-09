package com.ftc.fia.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */
@Entity
@Table(name = "position")
public class Position {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "position")
    private Collection<PositionHardware> positionHardwares = new ArrayList<>();

    public Position() {
    }

    public Position(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<PositionHardware> getPositionHardwares() {
        return positionHardwares;
    }

    public void setPositionHardwares(Collection<PositionHardware> positionHardwares) {
        this.positionHardwares = positionHardwares;
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
        Position position = (Position) o;
        return getId() == position.getId() &&
                Objects.equals(getDescription(), position.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription());
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
