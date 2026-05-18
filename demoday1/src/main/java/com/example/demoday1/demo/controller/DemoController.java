package com.example.demoday1.demo.controller;

import com.example.demoday1.demo.service.IDemoService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final IDemoService demoService1;

    public DemoController(IDemoService demoService) {
        this.demoService1 = demoService;
    }
}
