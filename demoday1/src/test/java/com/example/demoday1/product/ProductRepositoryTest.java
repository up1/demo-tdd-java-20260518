package com.example.demoday1.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.postgresql.PostgreSQLContainer;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Testcontainers
class ProductRepositoryTest {

    @Container
    static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres");

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("Success with get product = 1")
    public void case01(){
        // Arrange
        long id = 1;
        Product product1 = new Product();
        product1.setName("Test name 01");
        productRepository.save(product1);
        // Act
        Optional<Product> result = productRepository.findById(id);
        // Assert
        assertTrue(result.isPresent());
        assertEquals(1, result.get().getId());
        assertEquals("Test name 01", result.get().getName());
    }

    @Test
    @DisplayName("Product id=2 not found")
    public void case02(){
        // Act
        Optional<Product> result = productRepository.findById(2l);
        // Assert
        assertFalse(result.isPresent());
    }

}