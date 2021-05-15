package com.acme.agroassist.resource;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class SaveFarmerResource {
    @NotNull
    String username;

    @NotNull
    String email;

    @NotNull
    String firstName;

    @NotNull
    String lastName;

    public String getUsername() {
        return username;
    }

    public SaveFarmerResource setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SaveFarmerResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public SaveFarmerResource setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SaveFarmerResource setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
