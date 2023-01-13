package com.example.Test25;

import static org.junit.jupiter.api.Assertions.*;

import com.example.Test25.config.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
}