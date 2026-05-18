package com.example.demoday1.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ProductServiceSpringBootTest {

    @Autowired
    private ProductService productService;

    @Test
    public void case01(){
        // Act
        ProductResponse response =  productService.getById(1);
        // Assert
        assertEquals(1, response.getId());
    }

}