package com.ftc.fia.domain;

import org.hibernate.type.descriptor.sql.LobTypeMappings;

import javax.persistence.*;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */
@Entity
@Table(name = "user_preference")
public class User_Preferences {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Lob
    @Column(name = "profile_Pic")
    private Byte[] profile_pic;

    @Column(name = "send_user_notifs")
    private boolean send_user_notifs;

    @Column(name = "send_admin_notifs")
    private boolean send_admin_notifs;

    public User_Preferences() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Byte[] getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(Byte[] profile_pic) {
        this.profile_pic = profile_pic;
    }

    public boolean isSend_user_notifs() {
        return send_user_notifs;
    }

    public void setSend_user_notifs(boolean send_user_notifs) {
        this.send_user_notifs = send_user_notifs;
    }

    public boolean isSend_admin_notifs() {
        return send_admin_notifs;
    }

    public void setSend_admin_notifs(boolean send_admin_notifs) {
        this.send_admin_notifs = send_admin_notifs;
    }
}
