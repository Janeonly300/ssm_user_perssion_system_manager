package com.atjianyi.dao;

import com.atjianyi.pojo.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 简一
 * @className ProductMapper
 * @Date 2021/2/19 16:02
 **/
@Repository
public interface ProductMapper {

 List<Product> findAllProducts();
}
