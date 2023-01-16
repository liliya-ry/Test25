package com.example.Test25.test_classes;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class SomeClass {
    @Autowired
    @Qualifier("item")
    Book book;

    @Autowired
    public SomeClass(Book book) {
        this.book = book;
    }
}
