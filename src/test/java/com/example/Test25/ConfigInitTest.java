package com.example.Test25;

import com.example.Test25.test_classes.config.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ConfigInitTest {
	ApplicationContext context;

	@Test
	void createConfiguration() {
		assertDoesNotThrow(() -> context = new AnnotationConfigApplicationContext(Config.class));
	}

	@Test
	@DisplayName("Missing bean for autowired field")
	void createConfiguration1() {
		assertThrows(UnsatisfiedDependencyException.class,
				() -> context = new AnnotationConfigApplicationContext(Config1.class));
	}

	@Test
	@DisplayName("Autowired field in constructor params")
	void createConfiguration2() {
		assertThrows(BeanCreationException.class,
				() -> context = new AnnotationConfigApplicationContext(Config2.class));
	}

	@Test
	@DisplayName("Missing been for autowired setter")
	void createConfiguration3() {
		assertThrows(UnsatisfiedDependencyException.class,
				() -> context = new AnnotationConfigApplicationContext(Config3.class));
	}

	@Test
	@DisplayName("Two unqualified beans for interface")
	void createConfiguration4() {
		assertThrows(UnsatisfiedDependencyException.class,
				() -> context = new AnnotationConfigApplicationContext(Config4.class));
	}
}