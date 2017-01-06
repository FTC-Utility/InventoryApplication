package com.ftc.fia.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/30/2016.
 */
@Entity
@Table(name = "user_token")
public class UserToken {

    private int id;

    private TokenType tokenType;

    private User user;

    private String value;

    @Type(type = "com.ftc.fia.util.LocalDateTimeAttributeConverter")
    private LocalDateTime expireDate;

    public UserToken() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name ="toke_type_id", referencedColumnName = "id",foreignKey = @ForeignKey(name = "FkUserTokens_TokenTypeID"))
    public TokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id",foreignKey = @ForeignKey(name="FkUserTokens_UserId"))
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }

    @Column(name = "expire_date")
    public void setExpireDate(LocalDateTime expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserToken)) return false;
        UserToken userToken = (UserToken) o;
        return getId() == userToken.getId() &&
                Objects.equals(getTokenType(), userToken.getTokenType()) &&
                Objects.equals(getUser(), userToken.getUser()) &&
                Objects.equals(getValue(), userToken.getValue()) &&
                Objects.equals(getExpireDate(), userToken.getExpireDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTokenType(), getUser(), getValue(), getExpireDate());
    }

    @Override
    public String toString() {
        return "UserToken{" +
                "id=" + id +
                ", tokenType=" + tokenType +
                ", user=" + user +
                ", value='" + value + '\'' +
                ", expireDate=" + expireDate +
                '}';
    }
}
