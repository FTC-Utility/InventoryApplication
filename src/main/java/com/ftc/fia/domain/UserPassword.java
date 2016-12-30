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

    private String password_hash;

    @Column(name = "created_date")
    @Type(type = "com.ftc.fia.util.LocalDateAttributeConverter")
    private LocalDate created_date;

    @Column(name = "expire_date")
    @Type(type = "com.ftc.fia.util.LocalDateAttributeConverter")
    private LocalDate expire_date;


    private UserPassword user_id;

    public UserPassword() {
    }

    public UserPassword(String password_hash, LocalDate created_date, LocalDate expire_date) {
        this.password_hash = password_hash;
        this.created_date = created_date;
/*        this.expire_date = expire_date;*/
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public LocalDate getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDate created_date) {
        this.created_date = created_date;
    }

    public LocalDate getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(LocalDate expire_date) {
        this.expire_date = expire_date;
    }

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public UserPassword getUser_id() {
        return user_id;
    }

    public void setUser_id(UserPassword user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPassword)) return false;
        UserPassword that = (UserPassword) o;
        return getId() == that.getId() &&
                Objects.equals(getPassword_hash(), that.getPassword_hash()) &&
                Objects.equals(getCreated_date(), that.getCreated_date()) &&
                Objects.equals(getExpire_date(), that.getExpire_date()) &&
                Objects.equals(getUser_id(), that.getUser_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPassword_hash(), getCreated_date(), getExpire_date(), getUser_id());
    }
}
