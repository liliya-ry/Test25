package com.example.Test25.test_classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Address {
    public String country;
    public String city;
    public String street;
    public int streetNum;

    @Autowired
    public void setStreetNum(int streetNum) {
        this.streetNum = streetNum;
    }
}
