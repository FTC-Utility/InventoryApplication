package com.ftc.fia.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/30/2016.
 */
@Entity
@Table(name = "role_permission")
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="site_role_id",referencedColumnName = "id")
    private WebsiteRole site_role_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="permission_id" , referencedColumnName = "id")
    private Permission permission_id;

    public RolePermission() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WebsiteRole getSite_role_id() {
        return site_role_id;
    }

    public void setSite_role_id(WebsiteRole site_role_id) {
        this.site_role_id = site_role_id;
    }

    public Permission getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(Permission permission_id) {
        this.permission_id = permission_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RolePermission)) return false;
        RolePermission that = (RolePermission) o;
        return getId() == that.getId() &&
                Objects.equals(getSite_role_id(), that.getSite_role_id()) &&
                Objects.equals(getPermission_id(), that.getPermission_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSite_role_id(), getPermission_id());
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "id=" + id +
                ", site_role_id=" + site_role_id +
                ", permission_id=" + permission_id +
                '}';
    }
}
