package com.ftc.fia.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * Created by Eyuel Tadesse on 12/30/2016.
 */
@Entity
@Table(name ="persistent_login")
public class PersistentLogin {

    int id;

    private String series;

    private User user;

    private String token;

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
    @JoinColumn(name ="user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name ="FkPersistentLogin_UserID"))
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "token",length = 64)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Column(name = "last_used",columnDefinition = "TIMESTAMP")
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
                ", userId=" + user +
                ", token='" + token + '\'' +
                ", last_used=" + lastUsed +
                '}';
    }


}
