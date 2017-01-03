package com.ftc.fia.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */
@Entity
@Table(name = "user_password")
public class UserPassword {

    private int id;

    private String passwordHash;

    @Column(name = "created_date")
    @Type(type = "com.ftc.fia.util.LocalDateAttributeConverter")
    private LocalDate createdDate;

    @Column(name = "expire_date")
    @Type(type = "com.ftc.fia.util.LocalDateAttributeConverter")
    private LocalDate expireDate;

    @Transient
    private String confirmPassword;


    private UserPassword userId;

    public UserPassword() {
    }

    public UserPassword(int id, String passwordHash, LocalDate createdDate, LocalDate expireDate, UserPassword userId) {
        this.id = id;
        this.passwordHash = passwordHash;
        this.createdDate = createdDate;
        this.expireDate = expireDate;
        this.userId = userId;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public UserPassword getUserId() {
        return userId;
    }

    public void setUserId(UserPassword userId) {
        this.userId = userId;
    }

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public UserPassword getUser_id() {
        return userId;
    }

    public void setUser_id(UserPassword user_id) {
        this.userId = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPassword)) return false;
        UserPassword that = (UserPassword) o;
        return Objects.equals(getPasswordHash(), that.getPasswordHash()) &&
                Objects.equals(getCreatedDate(), that.getCreatedDate()) &&
                Objects.equals(getExpireDate(), that.getExpireDate()) &&
                Objects.equals(getConfirmPassword(), that.getConfirmPassword()) &&
                Objects.equals(getUserId(), that.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPasswordHash(), getCreatedDate(), getExpireDate(), getConfirmPassword(), getUserId());
    }

    @Override
    public String toString() {
        return "UserPassword{" +
                "id=" + id +
                ", passwordHash='" + passwordHash + '\'' +
                ", createdDate=" + createdDate +
                ", expireDate=" + expireDate +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", userId=" + userId +
                '}';
    }
}
