package com.ftc.fia.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */
/*
@Entity
@Table(name = "website_roles")
public class Website_Roles {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "Website_Roles")
    private List<User_Role> user_role;

    public Website_Roles() {
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

    public List<User_Role> getUser_role() {
        return user_role;
    }

    public void setUser_role(List<User_Role> user_role) {
        this.user_role = user_role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Website_Roles)) return false;
        Website_Roles that = (Website_Roles) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription());
    }

    @Override
    public String toString() {
        return "Website_Roles{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
*/
