package com.wizardcoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Mark the class as a Spring Boot application entry point
@SpringBootApplication

public class ProductApplication  {
    public static void main(String[] args) {
        // Run the Spring Boot application and bootstrap the ProductApplication class
        SpringApplication.run(ProductApplication.class, args);
    }
}