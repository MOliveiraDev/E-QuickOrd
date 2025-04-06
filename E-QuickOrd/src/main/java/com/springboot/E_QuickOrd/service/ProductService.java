package com.springboot.E_QuickOrd.service;

import com.springboot.E_QuickOrd.entity.Product;
import com.springboot.E_QuickOrd.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createnewProduct(String name, String description, double price) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);

        return productRepository.save(product);
    }

    public List <Product> getAllProducts() {
        return productRepository.findAll();
    }
}
