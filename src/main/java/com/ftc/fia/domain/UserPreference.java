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
    private Byte[] profilePic;

    @Column(name = "send_user_notif")
    private boolean sendUserNotif;

    @Column(name = "send_admin_notif")
    private boolean sendAdminNotif;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="site_skin_name", referencedColumnName = "id")
    private WebsiteSkin websiteSkin;

    public UserPreference() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Byte[] getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(Byte[] profilePic) {
        this.profilePic = profilePic;
    }

    public boolean isSendUserNotif() {
        return sendUserNotif;
    }

    public void setSendUserNotif(boolean sendUserNotif) {
        this.sendUserNotif = sendUserNotif;
    }

    public boolean isSendAdminNotif() {
        return sendAdminNotif;
    }

    public void setSendAdminNotif(boolean sendAdminNotif) {
        this.sendAdminNotif = sendAdminNotif;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WebsiteSkin getWebsiteSkin() {
        return websiteSkin;
    }

    public void setWebsiteSkin(WebsiteSkin websiteSkin) {
        this.websiteSkin = websiteSkin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPreference)) return false;
        UserPreference that = (UserPreference) o;
        return getId() == that.getId() &&
                isSendUserNotif() == that.isSendUserNotif() &&
                isSendAdminNotif() == that.isSendAdminNotif() &&
                Arrays.equals(getProfilePic(), that.getProfilePic()) &&
                Objects.equals(getUser(), that.getUser()) &&
                Objects.equals(getWebsiteSkin(), that.getWebsiteSkin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProfilePic(), isSendUserNotif(), isSendAdminNotif(), getUser(), getWebsiteSkin());
    }

    @Override
    public String toString() {
        return "UserPreference{" +
                "id=" + id +
                ", profilePic=" + Arrays.toString(profilePic) +
                ", sendUserNotif=" + sendUserNotif +
                ", sendAdminNotif=" + sendAdminNotif +
                ", user=" + user +
                ", websiteSkin=" + websiteSkin +
                '}';
    }
}
