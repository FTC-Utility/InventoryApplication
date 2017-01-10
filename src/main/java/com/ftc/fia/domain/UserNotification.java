package com.ftc.fia.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */
@Entity
@Table(name = "user_notification")
public class UserNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="user_id", nullable = false, referencedColumnName = "id",foreignKey = @ForeignKey(name ="FkUserNotif_UserID" ))
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "notification_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkUserNotif_NotificationID"))
    private Notification notification;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "notification_type_id", nullable = false, referencedColumnName = "id",foreignKey = @ForeignKey(name="FkUserNotif_NotifTypeID"))
    private NotificationType notificationType;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userNotification")
    private Collection<Audit> audits = new ArrayList<>();

    @Column(name = "active", columnDefinition = "TINYINT", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean active;


    public UserNotification() {
    }

    public UserNotification(boolean active) {
        this.active = active;
    }

    public UserNotification(User user, Notification notification, NotificationType notificationType, boolean active) {
        this.user = user;
        this.notification = notification;
        this.notificationType = notificationType;
        this.active = active;
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

    public Collection<Audit> getAudits() {
        return audits;
    }

    public void setAudits(Collection<Audit> audits) {
        this.audits = audits;
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
