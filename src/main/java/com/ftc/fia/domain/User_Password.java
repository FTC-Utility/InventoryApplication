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
public class User_Password {


    private int id;


    private String password_hash;

    @Column(name = "created_date")
    @Type(type = "com.ftc.fia.util.LocalDateAttributeConverter")
    private LocalDate created_date;

    @Column(name = "expire_date")
    @Type(type = "com.ftc.fia.util.LocalDateAttributeConverter")
    private LocalDate expire_date;


    private User_Password user_id;

    public User_Password() {
    }

    public User_Password(String password_hash, LocalDate created_date, LocalDate expire_date) {
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
    public User_Password getUser_id() {
        return user_id;
    }

    public void setUser_id(User_Password user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User_Password)) return false;
        User_Password that = (User_Password) o;
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
