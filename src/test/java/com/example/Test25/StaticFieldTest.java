package com.example.Test25;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.Test25.static_field.A;
import com.example.Test25.static_field.C;
import com.example.Test25.static_field.Config;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class StaticFieldTest {
    ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(Config.class);
    }

    @Test
    @DisplayName("static field - non static setter")
    void test1() {
        assertNotNull(A.bField);
    }

    @Test
    @DisplayName("static field - static setter")
    void test2() { //Autowired annotation not supported on static methods
        C c = context.getBean(C.class);
        C.setAField(new A());
        assertNotNull(C.aField);
    }

}

