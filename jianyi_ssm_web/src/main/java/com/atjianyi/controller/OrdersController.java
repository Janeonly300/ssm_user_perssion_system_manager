package com.atjianyi.controller;

import com.atjianyi.pojo.Orders;
import com.atjianyi.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 简一
 * @className OrdersController
 * @Date 2021/2/22 17:02
 **/
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/findAllOrders.do")
    public ModelAndView findAllOrders() throws Exception {
        //查询所有
        List<Orders> allOrders = ordersService.findAllOrders();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ordersList",allOrders);
        modelAndView.setViewName("orders-list");
        System.out.println(allOrders);
        return modelAndView;
    }

    @RequestMapping("/findAllOrdersByPage.do")
    public ModelAndView findAllByPage(@RequestParam(name = "curPage",defaultValue = "1") int curPage,@RequestParam(name = "size",defaultValue = "5")int size)throws Exception{
        //查询所有
        List<Orders> allOrdersByPage = ordersService.findAllOrdersByPage(curPage, size);
        //分页对象
        PageInfo<Orders> pageInfo = new PageInfo<>(allOrdersByPage);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-list");
        return modelAndView;

    }
}
