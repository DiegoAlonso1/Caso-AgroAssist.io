package com.acme.agroassist.resource;

import javax.validation.constraints.NotNull;

public class FarmlandResource {
    Long id;
    Long altitude;
    Long latitude;
    Long longitude;
    Long length;
    Long width;

    public Long getId() {
        return id;
    }

    public FarmlandResource setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getAltitude() {
        return altitude;
    }

    public FarmlandResource setAltitude(Long altitude) {
        this.altitude = altitude;
        return this;
    }

    public Long getLatitude() {
        return latitude;
    }

    public FarmlandResource setLatitude(Long latitude) {
        this.latitude = latitude;
        return this;
    }

    public Long getLongitude() {
        return longitude;
    }

    public FarmlandResource setLongitude(Long longitude) {
        this.longitude = longitude;
        return this;
    }

    public Long getLength() {
        return length;
    }

    public FarmlandResource setLength(Long length) {
        this.length = length;
        return this;
    }

    public Long getWidth() {
        return width;
    }

    public FarmlandResource setWidth(Long width) {
        this.width = width;
        return this;
    }
}
