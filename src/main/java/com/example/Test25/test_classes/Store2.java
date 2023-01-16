package com.example.Test25.test_classes;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Store2 implements InitializingBean {
    @Autowired
    @Qualifier("title")
    public String name;

    @Override
    public void afterPropertiesSet() throws Exception {
        name = name + " " + "!";
    }
}
