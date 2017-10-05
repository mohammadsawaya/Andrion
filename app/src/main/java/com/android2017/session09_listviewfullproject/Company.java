package com.android2017.session09_listviewfullproject;

import java.io.Serializable;

/**
 * Created by mac on 26/09/2017.
 */

public class Company implements Serializable{
    private String name;
    private String country;
    private int year;

    public Company() {

    }

    public Company(String name, String country, int year) {
        setName(name);
        setCountry(country);
        setYear(year);
    }

    @Override
    public String toString() {
        return name + " " + year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
