package com.example.Test25;

import static org.junit.jupiter.api.Assertions.*;

import com.example.Test25.multiple_configs.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class MultipleConfigsTest {
    ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new ClassPathXmlApplicationContext("combo-config.xml");
    }

    @Test
    @DisplayName("Class bean exists in two configurations and xml")
    void test1() {
        A a = context.getBean(A.class);
        assertNotNull(a);
        assertNull(a.configClass); // configured from xml
    }

    @Test
    @DisplayName("Named bean exists in one of two configurations - get by name")
    void test2() {
        B b = context.getBean("B", B.class);
        assertNotNull(b);
        assertEquals(b.configClass, Config.class);
    }

    @Test
    @DisplayName("Named bean exists in one of two configurations - get by type")
    void test3() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> context.getBean(B.class));
    }

    @Test
    @DisplayName("Named bean exists in two configurations - get by name")
    void test4() {
        C c = context.getBean("C", C.class);
        assertNotNull(c);
        assertEquals(c.configClass, Config2.class);
    }

    @Test
    @DisplayName("Named bean exists in two configurations - get by type")
    void test5() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> context.getBean(C.class));
    }

    @Test
    @DisplayName("Class bean exists in one of two configurations")
    void test6() {
        D d = context.getBean(D.class);
        assertNotNull(d);
        assertEquals(d.configClass, Config.class);
    }

    @Test
    @DisplayName("Class bean exists in two configurations")
    void test7() {
        E e = context.getBean(E.class);
        assertNotNull(e);
        assertEquals(e.configClass, Config2.class);
    }

    @Test
    @DisplayName("Class bean exists in xml")
    void test8() {
        F f = context.getBean(F.class);
        assertNotNull(f);
        assertNull(f.configClass); // configured from xml
    }
}
