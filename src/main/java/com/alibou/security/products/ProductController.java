package com.alibou.security.products;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSpecificShoe(@PathVariable Long id){
        return ResponseEntity.ok(service.getSpecificProduct(id));
    }

    @PostMapping
    public ResponseEntity<?> createNewShoe (@RequestBody Products product){
        service.createNewProduct(product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShoe(@PathVariable Long id){
        service.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
