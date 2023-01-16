package com.example.Test25.test_classes.config;

import com.example.Test25.test_classes.Author1;
import com.example.Test25.test_classes.Author2;
import com.example.Test25.test_classes.CookingBook;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("test_classes")
public class Config4 {
    @Bean
    public CookingBook cookingBook() {
        return new CookingBook();
    }

    @Bean
    public Author1 author1() {
        return new Author1();
    }

    @Bean
    public Author2 author2() {
        return new Author2();
    }
}
