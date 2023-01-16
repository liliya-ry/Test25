package com.example.Test25.triple_injection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("triple_injection")
@Configuration
public class Config {
    @Bean
    public A a() {
        return new A("constructor");
    }

    @Bean
    public B b() {
        System.out.println("constructor");
        return new B(a());
    }

    @Bean
    public String name() {
        System.out.println("field");
        return "field";
    }

    @Bean
    public A setName() {
        A a = new A();
        a.setName("setter");
        return a;
    }

    @Bean
    public B setAField() {
        System.out.println("setter");
        B b = new B();
        b.setaField(a());
        return b;
    }
}
