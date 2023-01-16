package com.example.Test25.test_classes.config;

import com.example.Test25.test_classes.*;
import org.springframework.context.annotation.*;

@ComponentScan("test_classes")
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
        Store store = new Store();
        store.name = title();
        return store;
    }

    @Bean
    public Store setTopBook() {
        Store store = new Store();
        store.topBook = book();
        return store;
    }

    @Bean
    public CookingBook cookingBook() {
        return new CookingBook();
    }

    @Bean("author1")
    public Author1 author1() {
        return new Author1();
    }

    @Bean("author2")
    public Author2 author2() {
        return new Author2();
    }

    @Bean
    public Store2 store2() {
        return new Store2();
    }

    @Bean
    public LazyContainingClass lazyContainingClass() {
        return new LazyContainingClass();
    }

//    @Lazy
//    @Bean
//    public LazyClass lazyClass() {
//        return new LazyClass();
//    }
}
