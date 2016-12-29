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
@Table(name ="notification_type")
public class Notification_Type {

    @Id
    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    public Notification_Type() {
    }

    public Notification_Type(String type, String description) {
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
        if (!(o instanceof Notification_Type)) return false;
        Notification_Type that = (Notification_Type) o;
        return Objects.equals(getType(), that.getType()) &&
                Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getDescription());
    }
}
