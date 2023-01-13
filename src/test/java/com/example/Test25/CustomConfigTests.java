package com.example.Test25;

import static org.junit.jupiter.api.Assertions.*;

import com.example.Test25.config.Config;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class CustomConfigTests {
    ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(Config.class);
    }


    @Test
    void beanCreation1() {
        Book book = context.getBean(Book.class);
        assertNotNull(book);
        assertNotNull(book.author);
        assertNotNull(book.publisher);
        assertNotNull(book.title);
    }

    @Test
    void beanCreation2() {
        Author author = context.getBean(Author.class);
        assertNotNull(author);
    }

    @Test
    void missingTypedBean() {
        assertThrows(NoSuchBeanDefinitionException.class, () -> context.getBean(SomeClass.class));
    }

    @Test
    void missingNamedBean() {
        assertThrows(NoSuchBeanDefinitionException.class, () -> context.getBean("item1"));
    }

    @Test
    void autowiredConstructor() {
        Book book = context.getBean(Book.class);
        assertNotNull(book);
        assertNotNull(book.title);
    }

    @Test
    void autowiredField() {
        Publisher publisher = context.getBean(Publisher.class);
        assertNotNull(publisher);
    }

    @Test
    void existingNamedBean() {
        Book book = context.getBean("book", Book.class);
        assertNotNull(book);
    }

    @Test
    void notExistingNamedBean() {
        assertThrows(NoSuchBeanDefinitionException.class, () -> context.getBean("addres", Address.class));
    }

    @Test
    void stringBean() {
        String title = (String) context.getBean("title");
        assertEquals("sample title", title);
    }

    @Test
    void stringBean1() {
        Store store = context.getBean("store", Store.class);
        assertNotNull(store);
        assertEquals("sample title", store.name);
    }

    @Test
    void twoBeansForClass() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> context.getBean(Store.class));
    }

    @Test
    void test1() {
        Person person = context.getBean(Person.class);
        System.out.println(person.firstName);
    }
}
