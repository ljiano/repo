package com.ljo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ljo.dao.IProductDao;
import com.ljo.dto.Product;
import com.ljo.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by jb.liang on 2017/4/10.
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Resource
    private IProductDao productDao;

    public void saveProduct(Product product) {
        productDao.insert(product);
    }

    public PageInfo<Product> findAllProductsByUm(Map param, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Product> list = productDao.findProducts(param);
        //用PageInfo对结果进行包装
        PageInfo<Product> page = new PageInfo<Product>(list);
        return page;
    }

    public void editProduct(Product product) {

    }

    public void removeProduct(Product product) {

    }

    public Product findProductById(int productId) {
        return productDao.selectByPrimaryKey(productId);
    }

    public List<Product> findProductsByPm(String pm) {
        return this.productDao.findProductByPm(pm);
    }
}
