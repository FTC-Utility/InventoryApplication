package com.ftc.fia.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "fistName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "email",nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name="company_id",referencedColumnName = "id")
    private Company company_id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id",referencedColumnName = "id")
    private List<UserNotification> userNotifications;

    @OneToOne
    @JoinColumn(name = "user_password_id",referencedColumnName = "id")
    private UserPassword user_password_id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="position_name", referencedColumnName = "name")
    private Position position_name;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserRole> user_roles;


    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Company getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Company company_id) {
        this.company_id = company_id;
    }

    public List<UserNotification> getUserNotifications() {
        return userNotifications;
    }

    public void setUserNotifications(List<UserNotification> userNotifications) {
        this.userNotifications = userNotifications;
    }

    public UserPassword getUser_password_id() {
        return user_password_id;
    }

    public void setUser_password_id(UserPassword user_password_id) {
        this.user_password_id = user_password_id;
    }

    public Position getPosition_name() {
        return position_name;
    }

    public void setPosition_name(Position position_name) {
        this.position_name = position_name;
    }

    public List<UserRole> getUser_roles() {
        return user_roles;
    }

    public void setUser_roles(List<UserRole> user_roles) {
        this.user_roles = user_roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                Objects.equals(getFirstName(), user.getFirstName()) &&
                Objects.equals(getLastName(), user.getLastName()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getCompany_id(), user.getCompany_id()) &&
                Objects.equals(getUserNotifications(), user.getUserNotifications()) &&
                Objects.equals(getUser_password_id(), user.getUser_password_id()) &&
                Objects.equals(getPosition_name(), user.getPosition_name()) &&
                Objects.equals(getUser_roles(), user.getUser_roles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getCompany_id(), getUserNotifications(), getUser_password_id(), getPosition_name(), getUser_roles());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", company_id=" + company_id +
                ", userNotifications=" + userNotifications +
                ", user_password_id=" + user_password_id +
                ", position_name=" + position_name +
                ", user_roles=" + user_roles +
                '}';
    }
}
