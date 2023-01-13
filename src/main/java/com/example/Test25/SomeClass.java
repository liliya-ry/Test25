package com.example.Test25;

import org.springframework.beans.factory.annotation.*;

public class SomeClass {
    @Autowired
    @Qualifier("item")
    Book book;

    @Autowired
    public SomeClass(Book book) {
        this.book = book;
    }
}
