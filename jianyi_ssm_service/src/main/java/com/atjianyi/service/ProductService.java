package com.atjianyi.service;

import com.atjianyi.pojo.Product;

import java.util.List;

public interface ProductService {
    void saveProduct(Product product) throws Exception;

    /**
     * 查看所有记录
     * @return
     * @throws Exception
     */
    List<Product> findAllProducts() throws Exception;

}
