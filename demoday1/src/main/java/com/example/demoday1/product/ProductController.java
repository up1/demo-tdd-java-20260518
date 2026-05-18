package com.example.demoday1.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/api/products/{id}")
    public ProductResponse getById(@PathVariable int id) {
        // 404
        if(id == 2) {
            throw new ProductNotFoundException("Product not found");
        }

        ProductResponse product = productService.getById(id);
        return product;
    }

}
