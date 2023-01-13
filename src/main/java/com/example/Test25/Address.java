package com.example.Test25;
import org.springframework.beans.factory.annotation.Autowired;

public class Address {
    String country;
    String city;
    String street;
    private int streetNum;

    @Autowired
    public void setStreetNum(int streetNum) {
        this.streetNum = streetNum;
    }
}
