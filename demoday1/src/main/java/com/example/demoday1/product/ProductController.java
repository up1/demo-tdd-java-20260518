package com.example.demoday1.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/api/products/{id}")
    public ProductResponse getById(@PathVariable int id) {
        var product = new ProductResponse();
        product.setId(id);
        product.setName("Demo product name");
        product.setPrice(100);
        return product;
    }

}
