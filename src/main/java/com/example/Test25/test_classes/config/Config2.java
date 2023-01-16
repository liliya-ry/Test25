package com.example.Test25.test_classes.config;

import com.example.Test25.test_classes.Author;
import com.example.Test25.test_classes.Book;
import com.example.Test25.test_classes.Publisher;
import com.example.Test25.test_classes.SomeClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("test_classes")
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
