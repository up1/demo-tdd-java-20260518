package com.example.demoday1.product;

import com.example.demoday1.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(exception = ProductNotFoundException.class)
    public ErrorResponse notFound(ProductNotFoundException e){
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
        return errorResponse;
    }

}
