package com.ftc.fia.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */
@Entity
@Table(name ="notification")
public class Notification {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column(name = "description")
    private String description;

    public Notification() {
    }

    public Notification(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Notification(String description) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notification)) return false;
        Notification that = (Notification) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription());
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
