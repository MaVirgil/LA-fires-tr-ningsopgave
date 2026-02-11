package org.mavirgil.lafires.model;

import jakarta.persistence.*;

@Entity
public class Siren {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private Location location;

    private boolean danger;

    public Siren() {
    }

    public Siren(Integer id, Location location, boolean danger) {
        this.id = id;
        this.location = location;
        this.danger = danger;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isDanger() {
        return danger;
    }

    public void setDanger(boolean danger) {
        this.danger = danger;
    }
}
