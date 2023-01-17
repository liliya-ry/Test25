package com.example.Test25;

import static org.junit.jupiter.api.Assertions.*;

import com.example.Test25.properties.*;
import org.junit.jupiter.api.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class PropertiesTest {
    ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(Config.class);
    }

    @Test
    void test1() {
        A a = context.getBean(A.class);
        assertNotNull(a);
        assertEquals("HR", a.database);
        assertEquals(true, a.flag);
        assertNotEquals(89.95, a.percent);
        assertEquals(1, a.count);
    }
}

