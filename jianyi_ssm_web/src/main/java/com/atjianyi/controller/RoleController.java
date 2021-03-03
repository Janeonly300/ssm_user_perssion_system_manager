package com.atjianyi.controller;

import com.atjianyi.pojo.Role;
import com.atjianyi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 简一
 * @className RoleController
 * @Date 2021/3/2 23:17
 **/
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAllRoles.do")
    public ModelAndView findAllRoles(){
        List<Role> allRoles = roleService.findAllRoles();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allRoles",allRoles);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String saveRole(Role role) throws Exception {
        roleService.saveRole(role);

        return "redirect:findAllRoles.do";
    }
}
