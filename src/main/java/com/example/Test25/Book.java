package com.example.Test25;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Autowired
    String title;
    Author author;
    Publisher publisher;

    @Autowired
    public Book(String title, Author author, Publisher publisher) {
        this.author = author;
        this.publisher = publisher;
        this.title = title;
    }
}
