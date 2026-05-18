package com.example.demoday1;

import java.util.Random;

public class Hello {
    public String say(String name) {
        return "Hello " + name;
    }

    private Random random;

    public Hello() {
    }

    public Hello(Random random) {
        this.random = random;
    }

    public String say2(String name) {
        int number = random.nextInt(10);
        return "Hello " + name + number;
    }
}
