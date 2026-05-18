package com.example.demoday1.gateway;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.util.ResourceUtils;
import org.wiremock.spring.ConfigureWireMock;
import org.wiremock.spring.EnableWireMock;
import org.wiremock.spring.InjectWireMock;

import java.io.File;
import java.nio.file.Files;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableWireMock({@ConfigureWireMock(name = "my-mock", port = 8888)})
class UserGatewayTest {

    @InjectWireMock("my-mock")
    WireMockServer mockUserService;

    @Autowired
    UserGateway userGateway;

    // Dynamically set the Feign URL to point to the local WireMock instance
    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("user.api.url", () -> "http://localhost:8888");
    }

    public static String read(String filePath) throws Exception {
        File file = ResourceUtils.getFile(filePath);
        return new String(Files.readAllBytes(file.toPath()));
    }

    @Test
    void getUserById() throws Exception {
        // Arrange
        mockUserService.stubFor(get(urlPathEqualTo("/users/1")).willReturn(aResponse().withBody(read("classpath:userApiResponse.json")).withHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).withStatus(200)));
        // Act
        UserResponse result = userGateway.getUserById(1L);
        // Assert
        assertEquals("demo", result.getUsername());
    }
}