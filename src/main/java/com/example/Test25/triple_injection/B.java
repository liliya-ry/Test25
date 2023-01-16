package com.example.Test25.triple_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class B {
    @Autowired
    public String name;
    public A aField;

    public B() {}

    @Autowired
    public B(A aField) {
        this.aField = aField;
    }

    @Autowired
    @Qualifier("a")
    public void setaField(A aField) {
        this.aField = aField;
    }
}
