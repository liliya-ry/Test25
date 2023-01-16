package com.example.Test25;

import static org.junit.jupiter.api.Assertions.*;

import com.example.Test25.xml_context.A;
import com.example.Test25.xml_context.B;
import com.example.Test25.xml_context.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



class XmlContextTest {
    ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new ClassPathXmlApplicationContext("config.xml");
    }

    @Test
    void createInstance() {
        C c = context.getBean(C.class);
        assertNotNull(c);
        assertNotNull(c.aField);
    }

    @Test
    void testPrototypeScope() {
        C c1 = context.getBean(C.class);
        C c2 = context.getBean(C.class);
        assertNotEquals(c1, c2);
    }

    @Test
    void testSingletonScope() {
        B b1 = context.getBean(B.class);
        B b2 = context.getBean(B.class);
        assertEquals(b1, b2);
    }

    @Test
    void circular1() {
        A a = context.getBean(A.class);
        assertNotNull(a);
        assertNotNull(a.bField);
        assertEquals(a, a.bField.aField);
        assertEquals(a.bField, a.bField.aField.bField);
    }

    @Test
    void circular2() {
        B b = context.getBean(B.class);
        assertNotNull(b);
        assertNotNull(b.aField);
        assertEquals(b, b.aField.bField);
        assertEquals(b.aField, b.aField.bField.aField);
    }

    @Test
    void testInstanceClass1() {
        A a = context.getBean(A.class);
        assertNotNull(a);
        assertEquals(a.bField.getClass(), B.class);
    }

    @Test
    void testInstanceClass2() {
        B b = context.getBean(B.class);
        assertNotNull(b);
        assertEquals(b.aField.getClass(), A.class);
    }
}
