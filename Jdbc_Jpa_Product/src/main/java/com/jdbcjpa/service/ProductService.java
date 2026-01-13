package com.jdbcjpa.service;

import com.jdbcjpa.entity.Product;
import java.util.List;

public interface ProductService {
    Product createProduct(Product prod);
    void deleteProduct(int productId);
    List<Product> getAllProducts();
}