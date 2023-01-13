package com.example.Test25.config;

import com.example.Test25.Author;
import com.example.Test25.Book;
import com.example.Test25.Publisher;
import com.example.Test25.SomeClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config2 {
    @Bean
    public SomeClass someClass() {
        return new SomeClass(book());
    }

    @Bean
    public Book book() {
        return new Book("some book", new Author(), new Publisher());
    }
}
