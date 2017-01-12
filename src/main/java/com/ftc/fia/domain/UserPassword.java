package com.ftc.fia.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */
@Entity
@Table(name = "user_password")
public class UserPassword {

    private int id;

    private String passwordHash;

    @Type(type = "com.ftc.fia.util.LocalDateTimeAttributeConverter")
    private LocalDateTime createdDate;


    @Type(type = "com.ftc.fia.util.LocalDateTimeAttributeConverter")
    private LocalDateTime expireDate;

    private String confirmPassword;

    private User user;

    public UserPassword() {
    }

    public UserPassword( String passwordHash, LocalDateTime createdDate, LocalDateTime expireDate) {
        this.passwordHash = passwordHash;
        this.createdDate = createdDate;
        this.expireDate = expireDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name ="password_hash")
    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Column(name = "create_date",columnDefinition = "TIMESTAMP")
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "expire_date", columnDefinition = "TIMESTAMP")
    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    @Transient
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",foreignKey = @ForeignKey(name ="FkUserPwd_UserID"))
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPassword)) return false;
        UserPassword that = (UserPassword) o;
        return getId() == that.getId() &&
                Objects.equals(getPasswordHash(), that.getPasswordHash()) &&
                Objects.equals(getCreatedDate(), that.getCreatedDate()) &&
                Objects.equals(getExpireDate(), that.getExpireDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPasswordHash(), getCreatedDate(), getExpireDate());
    }

    @Override
    public String toString() {
        return "UserPassword{" +
                "id=" + id +
                ", passwordHash='" + passwordHash + '\'' +
                ", createdDate=" + createdDate +
                ", expireDate=" + expireDate +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
