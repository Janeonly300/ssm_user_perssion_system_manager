package com.atjianyi.controller;

import com.atjianyi.pojo.UserInfo;
import com.atjianyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 简一
 * @className UserController
 * @Date 2021/3/2 16:05
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户并且返回
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAllUser(){
        List<UserInfo> allUsers = userService.findAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userInfoList",allUsers);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }
}
