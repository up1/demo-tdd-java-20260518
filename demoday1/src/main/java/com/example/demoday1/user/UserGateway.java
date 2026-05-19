package com.example.demoday1.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "user-service", url = "${user.api.url}")
public interface UserGateway {

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    List<UserResponse> getUsers();

    @RequestMapping(method = RequestMethod.GET, value = "/users/{userId}", produces = "application/json")
    UserResponse getUserById(@PathVariable("userId") Long postId);

}
