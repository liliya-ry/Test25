package com.example.Test25.config;

import com.example.Test25.Address;
import org.springframework.context.annotation.Bean;

public class Config3 {
    @Bean
    public Address address() {
        return new Address();
    }
}
