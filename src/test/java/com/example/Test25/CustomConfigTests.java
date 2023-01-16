package com.example.Test25;

import com.example.Test25.test_classes.*;
import com.example.Test25.test_classes.config.Config;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanNotOfRequiredTypeException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

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
    void notAutowiredField() {
        Publisher publisher = context.getBean(Publisher.class);
        assertNull(publisher.address);
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
    void autowiredField() {
        Publisher publisher = context.getBean(Publisher.class);
        assertNotNull(publisher);
        assertNotNull(publisher.store);
    }

    @Test
    void autowiredConstructor() {
        Book book = context.getBean(Book.class);
        assertNotNull(book);
        assertNotNull(book.title);
    }

    @Test
    void autowiredSetter() {
        Store store = context.getBean("store", Store.class);
        assertNotNull(store);
        assertNotNull(store.topBook);
    }

    @Test
    void beanNotOfRequiredType() {
        assertThrows(BeanNotOfRequiredTypeException.class, () -> context.getBean("store", Publisher.class));
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
    void abstractClassDefaultImplementation() {
        CookingBook cookingBook = context.getBean(CookingBook.class);
        assertNotNull(cookingBook);
        assertEquals(cookingBook.author1.getClass(), Author.class);
    }

    @Test
    @DisplayName("Default Interface when using Qualifier")
    void defaultInterfaceImpl1() {
        CookingBook cookingBook = context.getBean(CookingBook.class);
        assertNotNull(cookingBook);
        assertEquals(cookingBook.author2.getClass(), Author1.class);
        assertEquals(cookingBook.author3.getClass(), Author2.class);
    }


    @Test
    @DisplayName("Interface with two implementations")
    void interfaceTest() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> context.getBean(Human.class));
    }

    @Test
    void twoBeansForClass() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> context.getBean(Store.class));
    }

    @Test
    void testInitializer() {
        Store2 store2 = context.getBean(Store2.class);
        assertNotNull(store2);
        assertEquals("sample title !", store2.name);
    }

    @Test
    @Disabled
    void testLazyLoading() {
        LazyContainingClass lcs = context.getBean(LazyContainingClass.class);
        assertNotNull(lcs);
        assertNull(lcs.lazyInstance);
        System.out.println(lcs.lazyInstance.toString());
    }
}
