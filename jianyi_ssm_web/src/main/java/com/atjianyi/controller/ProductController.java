package com.atjianyi.controller;

import com.atjianyi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 简一
 * @className ProductController
 * @Date 2021/2/19 17:36
 **/

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/findAllProducts")
    public String findAllProduct(){
        System.out.println(productService.findAllProducts());
        return "ok.jsp";
    }
}
