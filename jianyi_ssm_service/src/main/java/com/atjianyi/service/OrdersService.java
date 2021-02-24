package com.atjianyi.service;

import com.atjianyi.pojo.Orders;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 简一
 * @className OrdersService
 * @Date 2021/2/22 16:59
 **/
public interface OrdersService {
    /**
     * 查询所有orders
     * @return
     */
    public List<Orders> findAllOrders() throws Exception;

    /**
     * 分页查询
     * @return
     */
    List<Orders> findAllOrdersByPage(int curPage,int size) throws Exception;

    /**
     * 查询订单详细信息
     * @param orderId
     * @return
     */
    Orders findOrderList(String orderId) throws Exception;
}
