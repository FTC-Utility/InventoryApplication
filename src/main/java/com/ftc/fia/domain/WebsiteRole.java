package com.ftc.fia.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */
@Entity
@Table(name = "website_role")
public class WebsiteRole {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

/*    @OneToMany
    @JoinColumn(name ="user_role_id", referencedColumnName = "id")
    private List<UserRole> user_role;*/

    public WebsiteRole() {
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

/*    public List<UserRole> getUser_role() {
        return user_role;
    }

    public void setUser_role(List<UserRole> user_role) {
        this.user_role = user_role;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WebsiteRole)) return false;
        WebsiteRole that = (WebsiteRole) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription());
    }

    @Override
    public String toString() {
        return "WebsiteRole{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}