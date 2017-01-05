package com.ftc.fia.domain;

import javax.persistence.*;

/**
 * Created by Zelalem Belay on 1/3/2017.
 */

@Entity
@Table(name = "position_software")
public class PositionSoftware
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    public PositionSoftware() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
