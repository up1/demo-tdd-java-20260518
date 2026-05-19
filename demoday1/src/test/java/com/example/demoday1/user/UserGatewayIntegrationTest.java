package com.example.demoday1.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserGatewayIntegrationTest {

    @Autowired
    private UserGateway userGateway;

    @Test
    void getUserById() {
        // Act
        UserResponse response = userGateway.getUserById(1l);
        // Assert
        assertEquals(1, response.getId());
        assertEquals("Sincere@april.biz", response.getEmail());
    }
}