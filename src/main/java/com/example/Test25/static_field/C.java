package com.example.Test25.static_field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class C {
    public static A aField;

    @Autowired
    @Qualifier("staticA")
    public static void setAField(A aField) {
        C.aField = aField;
    }
}
