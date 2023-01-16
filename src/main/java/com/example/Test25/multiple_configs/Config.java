package com.example.Test25.multiple_configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("multiple_configs")
@Configuration
public class Config {
    @Bean
    public A a() {
        A a = new A();
        a.configClass = Config.class;
        return a;
    }

    @Bean("B")
    public B b() {
        B b = new B();
        b.configClass = Config.class;
        return b;
    }

    @Bean("C")
    public C c() {
        C c = new C();
        c.configClass = Config.class;
        return c;
    }

    @Bean
    public D d() {
        D d = new D();
        d.configClass = Config.class;
        return d;
    }

    @Bean
    public E e() {
        E e = new E();
        e.configClass = Config.class;
        return e;
    }
}
