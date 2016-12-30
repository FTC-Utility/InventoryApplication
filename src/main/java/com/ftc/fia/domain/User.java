package com.ftc.fia.domain;

import javax.persistence.*;
import java.util.List;

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
    @JoinColumn(name="company_abbrev",referencedColumnName = "abbrev")
    private Company company_abbrev;

    @OneToMany
    @JoinColumn(name = "id",referencedColumnName = "")
    private List<UserNotification> userNotifications;

    @OneToOne
    @JoinColumn(name = "user_password_id",referencedColumnName = "id")
    private UserPassword user_password_id;

    @OneToOne
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

    public Company getCompany_abbrev() {
        return company_abbrev;
    }

    public void setCompany_abbrev(Company company_abbrev) {
        this.company_abbrev = company_abbrev;
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
}
