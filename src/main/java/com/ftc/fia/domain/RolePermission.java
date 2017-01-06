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
    @JoinColumn(name ="site_role_id",referencedColumnName = "id",foreignKey = @ForeignKey(name = "FkRolePerm_SiteRoleID"))
    private WebsiteRole websiteRole;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="permission_id" , referencedColumnName = "id",foreignKey = @ForeignKey(name = "FkRolePerm_PermissionID"))
    private Permission permission;

    public RolePermission() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WebsiteRole getWebsiteRole() {
        return websiteRole;
    }

    public void setWebsiteRole(WebsiteRole websiteRole) {
        this.websiteRole = websiteRole;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RolePermission)) return false;
        RolePermission that = (RolePermission) o;
        return getId() == that.getId() &&
                Objects.equals(getWebsiteRole(), that.getWebsiteRole()) &&
                Objects.equals(getPermission(), that.getPermission());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getWebsiteRole(), getPermission());
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "id=" + id +
                ", websiteRole=" + websiteRole +
                ", permission=" + permission +
                '}';
    }
}
