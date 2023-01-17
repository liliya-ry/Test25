package com.example.Test25.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class A {
    @Autowired
    @Value("${app.database}")
    public String database;
    @Autowired
    @Value("${app.percent}")
    public float percent;
    @Autowired
    @Value("${app.count}")
    public int count;
    @Autowired
    @Value("${app.flag}")
    public boolean flag;
}
