package com.example.Test25.test_classes.config;

import com.example.Test25.test_classes.Address;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("test_classes")
public class Config3 {
    @Bean
    public Address address() {
        return new Address();
    }
}
