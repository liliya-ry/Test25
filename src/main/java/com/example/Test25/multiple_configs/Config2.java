package com.example.Test25.multiple_configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("multiple_configs")
@Configuration
public class Config2 {
    @Bean
    public A a() {
        A a = new A();
        a.configClass = Config2.class;
        return a;
    }

    @Bean
    public B b() {
        B b = new B();
        b.configClass = Config2.class;
        return b;
    }

    @Bean("C")
    public C c() {
        C c = new C();
        c.configClass = Config2.class;
        return c;
    }

    @Bean
    public E e() {
        E e = new E();
        e.configClass = Config2.class;
        return e;
    }
}
