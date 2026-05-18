package com.example.demoday1.demo.service;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service @Lazy
public class DemoService1 implements IDemoService {

    public String process() {
        return "Demo service 1";
    }

}
