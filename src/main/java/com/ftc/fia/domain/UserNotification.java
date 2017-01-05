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
    @JoinColumn(name ="user_id",referencedColumnName = "id",foreignKey = @ForeignKey(name ="FkUserNotif_UserID" ))
    private User user;

    @ManyToOne
    @JoinColumn(name = "notification_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkUserNotif_NotificationID"))
    private Notification notification;

    @ManyToOne
    @JoinColumn(name = "notif_type_id", referencedColumnName = "id",foreignKey = @ForeignKey(name="FkUserNotif_NotifTypeID"))
    private NotificationType notificationType;

    @Column(name = "active", columnDefinition = "TINYINT")
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
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
                Objects.equals(getUser(), that.getUser()) &&
                Objects.equals(getNotification(), that.getNotification()) &&
                Objects.equals(getNotificationType(), that.getNotificationType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getNotification(), getNotificationType(), isActive());
    }

    @Override
    public String toString() {
        return "UserNotification{" +
                "id=" + id +
                ", userId=" + user +
                ", notification=" + notification +
                ", notificationType=" + notificationType +
                ", active=" + active +
                '}';
    }
}
