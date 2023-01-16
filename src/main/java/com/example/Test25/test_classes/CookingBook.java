package com.example.Test25.test_classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CookingBook {
    @Autowired
    public Person author1;

    @Autowired
    @Qualifier("author1")
    public Human author2;

    @Autowired
    @Qualifier("author2")
    public Human author3;
}
