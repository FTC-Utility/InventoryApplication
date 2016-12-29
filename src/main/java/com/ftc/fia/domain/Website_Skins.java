package com.ftc.fia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */
@Entity
@Table(name = "website_skins")
public class Website_Skins {

    @Id
    private String name;

    @Column(name = "css_fileName")
    private String css_fileName;

    public Website_Skins(String name, String css_fileName) {
        this.name = name;
        this.css_fileName = css_fileName;
    }

    public Website_Skins() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCss_fileName() {
        return css_fileName;
    }

    public void setCss_fileName(String css_fileName) {
        this.css_fileName = css_fileName;
    }

}
