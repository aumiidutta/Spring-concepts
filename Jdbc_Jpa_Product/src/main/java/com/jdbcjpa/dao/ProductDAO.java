package com.jdbcjpa.dao;

import com.jdbcjpa.entity.Product;
import com.jdbcjpa.mapper.ProductRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProductDAO {
    private final JdbcTemplate jt;
    private final String SQL_INSERT="insert into product(productName, productCost) values(?, ?)";
    private final String SQL_SELECT="select * from product where productId=?";
    private final String SQL_SELECT_ALL="select * from product";
    private final String SQL_DELETE="delete from product where productId=?";

    public ProductDAO(JdbcTemplate jt) {
        super();
        this.jt = jt;
    }

    public Product createProduct(Product prod) {
        jt.update(SQL_INSERT, prod.getProductName(), prod.getProductCost());
        Integer newId= jt.queryForObject("select last_insert_id()",Integer.class);
        return getProduct(newId);
    }

    public Product getProduct(int productId) {
        return (Product) jt.queryForObject(SQL_SELECT, new ProductRowMapper(), productId);
    }

    public List<Product> getAllProducts(){
        return jt.query(SQL_SELECT_ALL, new ProductRowMapper());
    }

    public int deleteProduct(int productId){
        return jt.update(SQL_DELETE, productId);
    }
}
