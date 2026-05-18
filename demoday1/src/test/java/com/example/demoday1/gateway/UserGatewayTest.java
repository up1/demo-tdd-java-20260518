package com.example.demoday1.gateway;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.wiremock.spring.ConfigureWireMock;
import org.wiremock.spring.EnableWireMock;
import org.wiremock.spring.InjectWireMock;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableWireMock({
        @ConfigureWireMock(
                name = "my-mock",
                port = 8888)
})
class UserGatewayTest {

    @InjectWireMock("my-mock")
    WireMockServer mockUserService;

    @Test
    void getUserById() {
    }
}