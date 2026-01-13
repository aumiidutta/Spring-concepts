package com.jdbcjpa.mapper;

import com.jdbcjpa.entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product prod=new Product();
        prod.setProductId(rs.getInt("productId"));
        prod.setProductName(rs.getString("productName"));
        prod.setProductCost(rs.getDouble("productCost"));
        return prod;
    }
}
