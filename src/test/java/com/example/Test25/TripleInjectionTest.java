package com.example.Test25;

import com.example.Test25.triple_injection.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class TripleInjectionTest {
    ApplicationContext context;

    @BeforeEach
    void setUp() {
        this.context = new AnnotationConfigApplicationContext(Config.class);
    }

    @Test //field -> constructor -> setter
    void test1() {
        A a = context.getBean("a", A.class);
        assertNotNull(a);
        assertNotEquals("constructor", a.name);
        assertEquals("field", a.name);
        assertNotEquals("setter", a.name);
    }

    @Test
    void test2() {
        B b = context.getBean("b", B.class);
        assertNotNull(b);
        assertEquals("field", b.name);
        assertNotNull(b.aField);
    }
}
