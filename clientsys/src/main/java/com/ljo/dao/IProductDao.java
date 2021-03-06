package com.ljo.dao;

import com.ljo.dto.Product;

import java.util.List;
import java.util.Map;

public interface IProductDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> findProducts(Map<String, Object> param);

    List<Product> findProductByPm(String comp);
}