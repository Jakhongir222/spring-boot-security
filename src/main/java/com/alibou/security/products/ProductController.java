package com.alibou.security.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping
    public ResponseEntity<?> getAllProducts(@RequestHeader(name="Authorization") String token) {
        return ResponseEntity.ok().header("Authorization", token).body(service.getAllProducts());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getSpecificProduct(@PathVariable Long id){
        return ResponseEntity.ok(service.getSpecificProduct(id));
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<?> getProductsByStoreId(@PathVariable String storeId) {
        return ResponseEntity.ok(service.getProductsByStoreId(storeId));
    }

    @PostMapping("/store/{storeId}/product")
    @PreAuthorize("#product.storeId == authentication.principal")
    public ResponseEntity<?> addProductToStore(@PathVariable String storeId, @RequestBody Products product) {
        product.setStoreId(storeId);
        service.createNewProduct(product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/store/{storeId}/product/{id}")
    @PreAuthorize("@productService.isProductBelongsToStore(authentication.principal, #storeId, #id)")
    public ResponseEntity<?> deleteProductFromStore(@PathVariable String storeId, @PathVariable Long id) {
        service.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
