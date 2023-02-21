package com.alibou.security.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    @Autowired
    JpaProductRepository repo;

    public Object getAllProducts() {
        return repo.findAll();
    }

    public Object getSpecificProduct(Long id) {
        return repo.findById(id);
    }

    public Object createNewProduct(Products product) {
        return repo.save(product);
    }

    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }
}
