package com.example.demoday1.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponse getById(int id) {
        // Call DB
        Optional<Product> result =  productRepository.findById((long) id);
        if(result.isPresent()) {

        }

        productRepository.save(new Product());
        productRepository.save(new Product());

        var product = new ProductResponse();
        product.setId(id);
        product.setName("Demo product name");
        product.setPrice(100);
        return product;
    }
}
