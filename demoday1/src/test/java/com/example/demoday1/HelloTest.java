package com.example.demoday1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class HelloTest {

    @Mock
    private Random random;

    @InjectMocks
    private Hello hello;

    @Test
    public void case02(){
        // Arrange
        when(random.nextInt(anyInt()))
                .thenReturn(5);
        // Act
        String result = hello.say2("somkiat");
        // Assert
        assertEquals("Hello somkiat5", result);
    }

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
