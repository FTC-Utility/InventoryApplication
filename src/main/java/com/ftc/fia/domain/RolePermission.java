package com.ftc.fia.domain;

import javax.persistence.*;

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
    @JoinColumn(name ="site_role_name",referencedColumnName = "name")
    private WebsiteRole site_role_name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="permission_name" , referencedColumnName = "name")
    private Permission permission_name;

    public RolePermission() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WebsiteRole getSite_role_name() {
        return site_role_name;
    }

    public void setSite_role_name(WebsiteRole site_role_name) {
        this.site_role_name = site_role_name;
    }

    public Permission getPermission_name() {
        return permission_name;
    }

    public void setPermission_name(Permission permission_name) {
        this.permission_name = permission_name;
    }
}
