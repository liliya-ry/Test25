package com.example.Test25.test_classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Book {
    public String title;
    public Author author;
    public Publisher publisher;

    @Autowired
    public Book(String title, Author author, Publisher publisher) {
        this.author = author;
        this.publisher = publisher;
        this.title = title;
    }

    @Autowired
    public void setAuthor(Author author) {
        this.author = author;
    }
}
