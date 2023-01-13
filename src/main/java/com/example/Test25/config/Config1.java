package com.example.Test25.config;

import com.example.Test25.Store;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config1 {
    @Bean
    public Store store() {
        return new Store();
    }
}