package com.example.Test25.static_field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
    public static B bField;

    @Autowired
    public void setbField(B bField) {
        A.bField = bField;
    }
}
