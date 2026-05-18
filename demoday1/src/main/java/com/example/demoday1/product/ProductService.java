package com.example.demoday1.product;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public ProductResponse getById(int id) {
        var product = new ProductResponse();
        product.setId(id);
        product.setName("Demo product name");
        product.setPrice(100);
        return product;
    }
}
