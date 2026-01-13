package com.jdbcjpa.service.impl;

import com.jdbcjpa.dao.ProductDAO;
import com.jdbcjpa.entity.Product;
import com.jdbcjpa.exception.ProductException;
import com.jdbcjpa.service.ProductService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("template")
public class JdbcProductServiceImpl implements ProductService {
    private final ProductDAO dao;

    public JdbcProductServiceImpl(ProductDAO dao) {
        this.dao = dao;
    }

    @Override
    public Product createProduct(Product prod){
        try {
            return dao.createProduct(prod);
        }
        catch(EmptyResultDataAccessException e) {
            throw new ProductException("INSERT FAILURE");
        }
    }

    @Override
    public void deleteProduct(int productId){
        int rows=dao.deleteProduct(productId);
        if(rows==0) {
            throw new ProductException("Deletion failure for productId: "+productId);
        }
    }

    @Override
    public List<Product> getAllProducts(){
        System.out.println("Using getAllProducts() with JdbcTemplate");
        return dao.getAllProducts();
    }
}
