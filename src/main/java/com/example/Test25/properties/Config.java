package com.example.Test25.properties;

import org.springframework.context.annotation.*;

@PropertySource("classpath:prop.properties")
@ComponentScan("properties")
@Configuration
public class Config {
    @Bean
    public A a() {
        return new A();
    }
}
