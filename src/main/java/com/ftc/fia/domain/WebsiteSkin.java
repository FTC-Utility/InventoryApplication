package com.ftc.fia.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */
@Entity
@Table(name = "website_skin")
public class WebsiteSkin {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column(name = "css_fileName", nullable = false)
    private String cssFileName;

    @Column(name = "full_name")
    private String fullName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "websiteSkin")
    private Collection<Audit> audits = new ArrayList<>();


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "websiteSkin")
    private Collection<UserPreference> userPreferences = new ArrayList<>();

    public WebsiteSkin(String fullName, String cssFileName) {
        this.fullName = fullName;
        this.cssFileName = cssFileName;
    }

    public WebsiteSkin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCssFileName() {
        return cssFileName;
    }

    public void setCssFileName(String cssFileName) {
        this.cssFileName = cssFileName;
    }

    public Collection<Audit> getAudits() {
        return audits;
    }

    public void setAudits(Collection<Audit> audits) {
        this.audits = audits;
    }

    public Collection<UserPreference> getUserPreferences() {
        return userPreferences;
    }

    public void setUserPreferences(Collection<UserPreference> userPreferences) {
        this.userPreferences = userPreferences;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WebsiteSkin)) return false;
        WebsiteSkin that = (WebsiteSkin) o;
        return getId() == that.getId() &&
                Objects.equals(getCssFileName(), that.getCssFileName()) &&
                Objects.equals(getFullName(), that.getFullName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCssFileName(), getFullName());
    }

    @Override
    public String toString() {
        return "WebsiteSkin{" +
                "id=" + id +
                ", cssFileName='" + cssFileName + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
