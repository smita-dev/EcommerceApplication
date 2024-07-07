package com.ecommereceApp.product_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@Testcontainers
class ProductServiceApplicationTests {

//	@Container
//	static MySQLContainer<?> mysqlContainer = new MySQLContainer<>(DockerImageName.parse("mysql:5.7.34"));
//
//	@DynamicPropertySource
//	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
//		dynamicPropertyRegistry.add("spring.datasource.url",mysqlContainer.getJdbcUrl());
//		dynamicPropertyRegistry.add("spring.datasource.username",mysqlContainer.getUsername());
//		dynamicPropertyRegistry.add("spring.datasource.password",mysqlContainer.getPassword());
//		dynamicPropertyRegistry.add("spring.datasource.driver-class-name",mysqlContainer.getDriverClassName());
//	}
	@Test
	void contextLoads() {
	}

}
