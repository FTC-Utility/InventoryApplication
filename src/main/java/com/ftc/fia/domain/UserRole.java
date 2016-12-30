package com.ftc.fia.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/29/2016.
 */
@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "site_role_name", referencedColumnName = "name")
    private WebsiteRole siteRoleName;

    public UserRole() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public WebsiteRole getSiteRoleName() {
        return siteRoleName;
    }

    public void setSiteRoleName(WebsiteRole siteRoleName) {
        this.siteRoleName = siteRoleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRole)) return false;
        UserRole user_role = (UserRole) o;
        return getId() == user_role.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", userId=" + userId +
                ", siteRoleName=" + siteRoleName +
                '}';
    }
}
