package com.ljo.service;

import com.github.pagehelper.PageInfo;
import com.ljo.dto.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by jb.liang on 2017/4/10.
 */
public interface IProductService {

    /**
     * 新增
     * @param product
     */
    public void saveProduct(Product product);

    /**
     * 获取
     * @param param
     * @return
     */
    public PageInfo<Product> findAllProductsByUm(Map param, Integer pageNo, Integer pageSize);

    /**
     * 编辑
     * @param product
     */
    public void editProduct(Product product);

    /**
     * 删除
     * @param product
     */
    public void removeProduct(Product product);

    /**
     * 获取
     * @param productId
     * @return
     */
    public Product findProductById(int productId);


    public List<Product> findProductsByPm(String pm);
}
