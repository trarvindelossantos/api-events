package com.events.apievents.models;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Component
public class Author {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    private String name;
    private String email;
    private String website;
    private String city;
    private String country;

    public Author() {

    }

    public Author(String id, String name, String email, String website, String city, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.website = website;
        this.city = city;
        this.country = country;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}
