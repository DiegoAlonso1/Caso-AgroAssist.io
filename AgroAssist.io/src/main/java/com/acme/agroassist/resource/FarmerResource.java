package com.acme.agroassist.resource;

import javax.persistence.Column;

public class FarmerResource {
    Long id;
    String username;
    String email;
    String firstName;
    String lastName;

    public Long getId() {
        return id;
    }

    public FarmerResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public FarmerResource setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public FarmerResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public FarmerResource setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public FarmerResource setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
