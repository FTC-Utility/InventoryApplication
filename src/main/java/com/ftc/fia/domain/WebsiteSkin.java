package com.ftc.fia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */
@Entity
@Table(name = "website_skin")
public class WebsiteSkin {

    @Id
    private String name;

    @Column(name = "css_fileName")
    private String cssFileName;

    @Column(name = "full_name")
    private String fullName;

    public WebsiteSkin(String name, String cssFileName) {
        this.name = name;
        this.cssFileName = cssFileName;
    }

    public WebsiteSkin() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCssFileName() {
        return cssFileName;
    }

    public void setCssFileName(String cssFileName) {
        this.cssFileName = cssFileName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "WebsiteSkin{" +
                "name='" + name + '\'' +
                ", cssFileName='" + cssFileName + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }


}
