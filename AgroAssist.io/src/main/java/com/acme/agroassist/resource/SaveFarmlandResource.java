package com.acme.agroassist.resource;

import javax.validation.constraints.NotNull;

public class SaveFarmlandResource {
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

    public Long getAltitude() {
        return altitude;
    }

    public SaveFarmlandResource setAltitude(Long altitude) {
        this.altitude = altitude;
        return this;
    }

    public Long getLatitude() {
        return latitude;
    }

    public SaveFarmlandResource setLatitude(Long latitude) {
        this.latitude = latitude;
        return this;
    }

    public Long getLongitude() {
        return longitude;
    }

    public SaveFarmlandResource setLongitude(Long longitude) {
        this.longitude = longitude;
        return this;
    }

    public Long getLength() {
        return length;
    }

    public SaveFarmlandResource setLength(Long length) {
        this.length = length;
        return this;
    }

    public Long getWidth() {
        return width;
    }

    public SaveFarmlandResource setWidth(Long width) {
        this.width = width;
        return this;
    }
}
