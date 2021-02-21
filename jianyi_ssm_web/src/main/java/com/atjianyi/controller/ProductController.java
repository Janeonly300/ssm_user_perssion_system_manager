package com.atjianyi.controller;

import com.atjianyi.pojo.Product;
import com.atjianyi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    @RequestMapping("/saveProduct.do")
    public void saveProduct(Product product, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        productService.saveProduct(product);
        req.getRequestDispatcher("findAllProducts.do").forward(req,resp);
    }

    /**
     * 查询所有商品
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAllProducts.do")
    public ModelAndView findAllProduct() throws Exception {
        List<Product> allProducts = productService.findAllProducts();
        System.out.println("执行。");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList",allProducts);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }
}
