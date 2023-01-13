package com.example.Test25.config;

import com.example.Test25.*;
import org.springframework.context.annotation.*;

@Configuration
public class Config {
    @Bean
    public String title() {
        return "sample title";
    }

    @Bean
    public Author author() {
        return new Author();
    }

    @Bean
    public Publisher publisher() {
        return new Publisher();
    }

    @Bean
    public Book book() {
        return new Book(title(), author(), publisher());
    }

    @Bean
    public Store store() {
        return new Store();
    }

    @Bean
    public Store setStore() {
        return new Store();
    }
}
