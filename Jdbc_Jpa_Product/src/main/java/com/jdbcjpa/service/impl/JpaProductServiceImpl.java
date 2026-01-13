package com.jdbcjpa.service.impl;

import com.jdbcjpa.entity.Product;
import com.jdbcjpa.exception.ProductException;
import com.jdbcjpa.repository.ProductRepository;
import com.jdbcjpa.service.ProductService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jpa")
public class JpaProductServiceImpl implements ProductService {
    private final ProductRepository repo;

    public JpaProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public Product createProduct(Product prod){
        return repo.save(prod);
    }

    @Override
    public List<Product> getAllProducts(){
        System.out.println("Using getAllProducts() with JpaRepository");
        return repo.findAll();
    }

    @Override
    public void deleteProduct(int productId){
        Product deleted=repo.findById(productId).orElseThrow(()->new ProductException("DELETION FAILURE FOR ID: "+productId));
        repo.delete(deleted);
    }
}
