package com.ftc.fia.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */
@Entity
@Table(name = "user_notification")
public class UserNotification {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name ="user_id",referencedColumnName = "id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "notif_name", referencedColumnName = "name")
    private Notification notifName;

    @ManyToOne
    @JoinColumn(name = "notif_type", referencedColumnName = "type")
    private NotificationType notifType;

    @Column(name = "active")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean active;


    public UserNotification() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser_id() {
        return userId;
    }

    public void setUser_id(User user_id) {
        this.userId = user_id;
    }

    public Notification getNotif_name() {
        return notifName;
    }

    public void setNotif_name(Notification notif_name) {
        this.notifName = notif_name;
    }

    public NotificationType getNotif_type() {
        return notifType;
    }

    public void setNotif_type(NotificationType notif_type) {
        this.notifType = notif_type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserNotification)) return false;
        UserNotification that = (UserNotification) o;
        return getId() == that.getId() &&
                isActive() == that.isActive() &&
                Objects.equals(getUser_id(), that.getUser_id()) &&
                Objects.equals(getNotif_name(), that.getNotif_name()) &&
                Objects.equals(getNotif_type(), that.getNotif_type());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser_id(), getNotif_name(), getNotif_type(), isActive());
    }

    @Override
    public String toString() {
        return "UserNotification{" +
                "id=" + id +
                ", user_id=" + userId +
                ", notif_name='" + notifName + '\'' +
                ", notif_type='" + notifType + '\'' +
                ", active=" + active +
                '}';
    }
}
