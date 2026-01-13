package com.jdbcjpa.controller;

import com.jdbcjpa.entity.Product;
import com.jdbcjpa.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service) {
        super();
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product prod){
        Product newProduct=service.createProduct(prod);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> list=service.getAllProducts();
        return ResponseEntity.status(200).body(list);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int productId) {
        service.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
