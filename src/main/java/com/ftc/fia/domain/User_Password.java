package com.ftc.fia.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */
@Entity
@Table(name = "user_password")
public class User_Password {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String password_hash;

    @Column(name = "created_date")
    @Type(type = "com.ftc.fia.util.LocalDateAttributeConverter")
    private LocalDate created_date;

    @Column(name = "expire_date")
    @Type(type = "com.ftc.fia.util.LocalDateAttributeConverter")
    private LocalDate expire_date;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User_Password user_id;

    public User_Password() {
    }

    public User_Password(String password_hash, LocalDate created_date, LocalDate expire_date) {
        this.password_hash = password_hash;
        this.created_date = created_date;
        this.expire_date = expire_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public User_Password getUser_id() {
        return user_id;
    }

    public void setUser_id(User_Password user_id) {
        this.user_id = user_id;
    }
}
