package com.atjianyi.controller;

import com.atjianyi.pojo.UserInfo;
import com.atjianyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public ModelAndView findAllUser() throws Exception {
        List<UserInfo> allUsers = userService.findAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userInfoList",allUsers);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    /**
     * 保存用户
     * @param userInfo
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveUser.do")
    public String findAllUser(UserInfo userInfo) throws Exception {
        userService.saveUser(userInfo);
        //转发
        return "redirect:findAll.do";
    }

    /**
     * 查询用户详细信息
     * @param id
     * @return
     */
    @RequestMapping("/findUserById.do")
    public ModelAndView findUserById(String id) throws Exception {
        UserInfo userInfo = userService.findUserById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userInfo",userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }
}