package com.atjianyi.service.impl;

import com.atjianyi.dao.ProductMapper;
import com.atjianyi.pojo.Product;
import com.atjianyi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author 简一
 * @className ProductServiceImpl
 * @Date 2021/2/19 16:36
 **/
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper mapper;

    @Override
    public void saveProduct(Product product) throws Exception {
        /**
         * 为商品生成uuid
         */
        product.setId(UUID.randomUUID().toString().replace("-",""));
        mapper.insertProduct(product);
    }

    public List<Product> findAllProducts() throws Exception {
        return mapper.findAllProducts();
    }
}
