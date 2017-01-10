package com.ftc.fia.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */
@Entity
@Table(name = "user")
@SequenceGenerator(name="seq", initialValue = 1, allocationSize = 100)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email",nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name="company_id",referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkUser_CompanyID"))
    private Company company;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name = "notification_id",referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkUserNotif_UserID"))
    private List<UserNotification> userNotifications;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="position_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FkUser_PositionID"))
    private Position position;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserRole> user_roles;

    @Column(name = "confirmed", columnDefinition = "TINYINT")
    private boolean confirmed;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private Collection<Assigned> assigneds = new ArrayList<>();

    @OneToMany(mappedBy = "requestor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Issue> RequestedIssues = new ArrayList<>();

    @OneToMany(mappedBy = "resolvedBy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Issue> resolvedIssues = new ArrayList<>();


    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User() {
    }

    public Collection<Issue> getRequestedissues() {
        return RequestedIssues;
    }

    public void setRequestedissues(Collection<Issue> requestedissues) {
        RequestedIssues = requestedissues;
    }

    public Collection<Issue> getResolvedissues() {
        return resolvedIssues;
    }

    public void setResolvedissues(Collection<Issue> resolvedissues) {
        this.resolvedIssues = resolvedissues;
    }

    public Collection<Assigned> getAssigneds() {
        return assigneds;
    }

    public void setAssigneds(Collection<Assigned> assigneds) {
        this.assigneds = assigneds;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<UserNotification> getUserNotifications() {
        return userNotifications;
    }

    public void setUserNotifications(List<UserNotification> userNotifications) {
        this.userNotifications = userNotifications;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<UserRole> getUser_roles() {
        return user_roles;
    }

    public void setUser_roles(List<UserRole> user_roles) {
        this.user_roles = user_roles;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                isConfirmed() == user.isConfirmed() &&
                Objects.equals(getFirstName(), user.getFirstName()) &&
                Objects.equals(getLastName(), user.getLastName()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getCompany(), user.getCompany()) &&
                Objects.equals(getUserNotifications(), user.getUserNotifications()) &&
                Objects.equals(getPosition(), user.getPosition()) &&
                Objects.equals(getUser_roles(), user.getUser_roles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getCompany(), getUserNotifications(), getPosition(), getUser_roles(), isConfirmed());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", company_id=" + company +
                ", userNotifications=" + userNotifications +
                ", position_id=" + position +
                ", user_roles=" + user_roles +
                ", confirmed=" + confirmed +
                '}';
    }
}
