package com.ftc.fia.domain;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */
@Entity
@Table(name = "user_preference")
public class UserPreference {

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

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user_id;

    @ManyToOne
    @JoinColumn(name="site_skin_name", referencedColumnName = "name")
    private Website_Skins website_skins;

    public UserPreference() {
    }

    public UserPreference(Byte[] profile_pic, boolean send_user_notifs, boolean send_admin_notifs, User user_id, Website_Skins website_skins) {
        this.profile_pic = profile_pic;
        this.send_user_notifs = send_user_notifs;
        this.send_admin_notifs = send_admin_notifs;
        this.user_id = user_id;
        this.website_skins = website_skins;
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

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Website_Skins getWebsite_skins() {
        return website_skins;
    }

    public void setWebsite_skins(Website_Skins website_skins) {
        this.website_skins = website_skins;
    }

    @Override
    public String toString() {
        return "UserPreference{" +
                "id=" + id +
                ", profile_pic=" + Arrays.toString(profile_pic) +
                ", send_user_notifs=" + send_user_notifs +
                ", send_admin_notifs=" + send_admin_notifs +
                ", user_id=" + user_id +
                ", website_skins=" + website_skins +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPreference)) return false;
        UserPreference that = (UserPreference) o;
        return getId() == that.getId() &&
                isSend_user_notifs() == that.isSend_user_notifs() &&
                isSend_admin_notifs() == that.isSend_admin_notifs() &&
                Arrays.equals(getProfile_pic(), that.getProfile_pic()) &&
                Objects.equals(getUser_id(), that.getUser_id()) &&
                Objects.equals(getWebsite_skins(), that.getWebsite_skins());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProfile_pic(), isSend_user_notifs(), isSend_admin_notifs(), getUser_id(), getWebsite_skins());
    }
}
