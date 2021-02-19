package com.atjianyi.service.impl;

import com.atjianyi.dao.ProductMapper;
import com.atjianyi.pojo.Product;
import com.atjianyi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 简一
 * @className ProductServiceImpl
 * @Date 2021/2/19 16:36
 **/
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper mapper;
    public List<Product> findAllProducts() throws Exception {
        return mapper.findAllProducts();
    }
}
