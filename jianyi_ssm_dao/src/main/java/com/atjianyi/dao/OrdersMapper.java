package com.atjianyi.dao;

import com.atjianyi.pojo.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 简一
 * @className OrddersMapper
 * @Date 2021/2/22 16:21
 **/
@Repository
public interface OrdersMapper {

    /**
     * 查询订单信息
     * @return
     * @throws Exception
     */
    public List<Orders> findAllOrders() throws Exception;
}
