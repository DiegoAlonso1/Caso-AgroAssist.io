package com.acme.agroassist.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "farmlands")
public class Farmland implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    Long altitude;

    @NotNull
    Long latitude;

    @NotNull
    Long longitude;

    @NotNull
    Long length;

    @NotNull
    Long width;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "farmer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Farmer farmer;

    public Long getId() {
        return id;
    }

    public Farmland setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getAltitude() {
        return altitude;
    }

    public Farmland setAltitude(Long altitude) {
        this.altitude = altitude;
        return this;
    }

    public Long getLatitude() {
        return latitude;
    }

    public Farmland setLatitude(Long latitude) {
        this.latitude = latitude;
        return this;
    }

    public Long getLongitude() {
        return longitude;
    }

    public Farmland setLongitude(Long longitude) {
        this.longitude = longitude;
        return this;
    }

    public Long getLength() {
        return length;
    }

    public Farmland setLength(Long length) {
        this.length = length;
        return this;
    }

    public Long getWidth() {
        return width;
    }

    public Farmland setWidth(Long width) {
        this.width = width;
        return this;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public Farmland setFarmer(Farmer farmer) {
        this.farmer = farmer;
        return this;
    }
}
