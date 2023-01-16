package com.example.Test25;

import com.example.Test25.static_field.A;
import com.example.Test25.static_field.Config;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class StaticInjectTest {
    ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(Config.class);
    }

    @Test
    void test1() {
        A a = context.getBean(A.class);
        assertNotNull(A.bField);
    }
}
