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

 /**
  * 查询所有商品
  * @return
  * @throws Exception
  */
 List<Product> findAllProducts() throws Exception;

 /**
  * 添加商品
  * @param product
  * @throws Exception
  */
 void insertProduct(Product product) throws Exception;

 /**
  * 根据id查询商品
  * @param id·
  * @return
  */
 Product findProductById(String id) throws Exception;
}
