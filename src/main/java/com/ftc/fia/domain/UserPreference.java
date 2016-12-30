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

    @Column(name = "send_user_notifs")
    private boolean sendUserNotifs;

    @Column(name = "send_admin_notifs")
    private boolean sendAdminNotifs;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User userId;

    @ManyToOne
    @JoinColumn(name="site_skin_name", referencedColumnName = "name")
    private WebsiteSkin websiteSkins;

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

    public boolean isSendUserNotifs() {
        return sendUserNotifs;
    }

    public void setSendUserNotifs(boolean sendUserNotifs) {
        this.sendUserNotifs = sendUserNotifs;
    }

    public boolean isSendAdminNotifs() {
        return sendAdminNotifs;
    }

    public void setSendAdminNotifs(boolean sendAdminNotifs) {
        this.sendAdminNotifs = sendAdminNotifs;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public WebsiteSkin getWebsiteSkins() {
        return websiteSkins;
    }

    public void setWebsiteSkins(WebsiteSkin websiteSkins) {
        this.websiteSkins = websiteSkins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPreference)) return false;
        UserPreference that = (UserPreference) o;
        return getId() == that.getId() &&
                isSendUserNotifs() == that.isSendUserNotifs() &&
                isSendAdminNotifs() == that.isSendAdminNotifs() &&
                Arrays.equals(getProfilePic(), that.getProfilePic()) &&
                Objects.equals(getUserId(), that.getUserId()) &&
                Objects.equals(getWebsiteSkins(), that.getWebsiteSkins());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProfilePic(), isSendUserNotifs(), isSendAdminNotifs(), getUserId(), getWebsiteSkins());
    }

    @Override
    public String toString() {
        return "UserPreference{" +
                "id=" + id +
                ", profilePic=" + Arrays.toString(profilePic) +
                ", sendUserNotifs=" + sendUserNotifs +
                ", sendAdminNotifs=" + sendAdminNotifs +
                ", userId=" + userId +
                ", websiteSkins=" + websiteSkins +
                '}';
    }
}
