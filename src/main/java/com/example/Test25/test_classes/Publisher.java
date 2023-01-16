package com.example.Test25.test_classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Publisher {
    public String name;
    public Address address;
    @Autowired
    public Store store;
}
