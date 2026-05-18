package com.example.demoday1.product;

import com.example.demoday1.ErrorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureTestRestTemplate
class ProductControllerTest {

    // HTTP Client
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void case01(){
        // Act
        ProductResponse result
                = restTemplate.getForObject("/api/products/1", ProductResponse.class);
        // Assert
        assertEquals(1, result.getId());
        assertEquals("Demo product name", result.getName());
        assertEquals(100, result.getPrice());
    }

    @Test
    public void case02(){
        // Act
        ResponseEntity<ErrorResponse> result
                = restTemplate.getForEntity("/api/products/2", ErrorResponse.class);
        // Assert
        assertEquals(404, result.getStatusCode().value());
        assertEquals("Product not found", result.getBody().getError());
    }

}