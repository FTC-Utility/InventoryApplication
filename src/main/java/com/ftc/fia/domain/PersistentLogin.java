package com.ftc.fia.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Eyuel Tadesse on 12/30/2016.
 */
@Entity
@Table(name ="persistent_login")
public class PersistentLogin {

    private String series;

    private User userId;

    private String token;

    @Column(name = "last_used")
    @Type(type = "com.ftc.fia.util.LocalDateTimeAttributeConverter")
    private LocalDateTime lastUsed;

    public PersistentLogin() {
    }

    @Id
    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="user_id", referencedColumnName = "id")
    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Column(name = "token",length = 64)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(LocalDateTime lastUsed) {
        this.lastUsed = lastUsed;
    }

    @Override
    public String toString() {
        return "PersistentLogin{" +
                "series='" + series + '\'' +
                ", userId=" + userId +
                ", token='" + token + '\'' +
                ", last_used=" + lastUsed +
                '}';
    }
}
