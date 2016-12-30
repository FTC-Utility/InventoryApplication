package com.ftc.fia.domain;

import javax.persistence.*;

/**
 * Created by Eyuel Tadesse on 12/30/2016.
 */
@Entity
@Table(name = "user_token")
public class UserToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name ="toke_type", referencedColumnName = "type")
    private TokeType tokenType;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;

    @Column(name = "value")
    private String value;

    public UserToken() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TokeType getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokeType tokenType) {
        this.tokenType = tokenType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
