package com.ftc.fia.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */
@Entity
@Table(name ="notification_type")
public class NotificationType {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "notificationType")
    private Collection<UserNotification> userNotifications = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "notificationType")
    private Collection<Audit> audits = new ArrayList<>();

    public NotificationType() {
    }

    public NotificationType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public NotificationType(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<UserNotification> getUserNotifications() {
        return userNotifications;
    }

    public void setUserNotifications(Collection<UserNotification> userNotifications) {
        this.userNotifications = userNotifications;
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
        if (!(o instanceof NotificationType)) return false;
        NotificationType that = (NotificationType) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription());
    }
}
