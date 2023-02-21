package com.alibou.security.products;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository repo;

    public Object getAllProducts() {
        return repo.getAllProducts();
    }

    public Object getSpecificProduct(Long id) {
        return repo.getSpecificProduct(id);
    }

    public Object createNewProduct(Products product) {
        return repo.createNewProduct(product);

    }

    public void deleteProduct(Long id) {
        repo.deleteProduct(id);
    }
}
