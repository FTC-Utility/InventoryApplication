package com.ftc.fia.domain;

import javax.persistence.*;

/**
 * Created by Zelalem Belay on 1/3/2017.
 */

@Entity
@Table(name = "position_hardware")
public class PositionHardware
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "quantity")
    private int quantity;

    public PositionHardware() {
    }

    public PositionHardware(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
