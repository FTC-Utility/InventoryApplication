package com.ftc.fia.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/29/2016.
 */
@Entity
@Table
public class User_Role {
    @Id
    @GeneratedValue
    private int id;

    public User_Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User_Role)) return false;
        User_Role user_role = (User_Role) o;
        return getId() == user_role.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
