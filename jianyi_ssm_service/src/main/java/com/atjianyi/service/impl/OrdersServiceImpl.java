package com.atjianyi.service.impl;

import com.atjianyi.dao.OrdersMapper;
import com.atjianyi.pojo.Orders;
import com.atjianyi.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 简一
 * @className OrdersServiceImpl
 * @Date 2021/2/22 17:00
 **/
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper mapper;
    @Override
    public List<Orders> findAllOrders() throws Exception {
        return mapper.findAllOrders();
    }

    @Override
    public List<Orders> findAllOrdersByPage(int curPage,int size) throws Exception {
        //调用分页方法
        PageHelper.startPage(curPage,size);
        List<Orders> allOrders = mapper.findAllOrders();
        return allOrders;
    }
}
