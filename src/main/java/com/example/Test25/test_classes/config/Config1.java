package com.example.Test25.test_classes.config;

import com.example.Test25.test_classes.Store;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("test_classes")
@Configuration
public class Config1 {
    @Bean
    public Store store() {
        return new Store();
    }
}