package com.abhishek.gocheeta.commons.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Intellij.
 * Author: abhis
 * Date: 04/08/2022
 * Time: 12:58 pm
 */
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue
    private int id;

    private String city;

    private boolean status;

    public City(int id, String city, boolean status) {
        this.id = id;
        this.city = city;
        this.status = status;
    }

    public City() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
