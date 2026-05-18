package com.example.demoday1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {

    @Test
    @DisplayName("case อะไร มี input อะไร เรียกอะไร")
    public void case01(){
        // Arrange
        Hello hello = new Hello();
        // Act
        String result = hello.say("somkiat");
        // Assert
        assertEquals("Hello somkiat", result);
    }

}
