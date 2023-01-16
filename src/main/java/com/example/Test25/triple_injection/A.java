package com.example.Test25.triple_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
    @Autowired
    public String name;

    public A() {}

    @Autowired
    public A(String name) {
        this.name = name;
    }

    @Autowired
    public void setName(String name) {
        this.name = name;
    }
}
