package com.example.Test25.test_classes;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class Store {
    @Autowired
    @Qualifier("title")
    public String name;

    public Book topBook;

    @Autowired
    public void setTopBook(Book topBook) {
        this.topBook = topBook;
    }
}
