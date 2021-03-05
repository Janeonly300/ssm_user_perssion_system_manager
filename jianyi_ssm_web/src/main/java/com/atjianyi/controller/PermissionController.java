package com.atjianyi.controller;

import com.atjianyi.pojo.Permission;
import com.atjianyi.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 简一
 * @className PermissionController
 * @Date 2021/3/3 15:25
 **/
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    /**
     * 查询所有权限信息
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAllPermissions() throws Exception {
        List<Permission> allPermissions = permissionService.findAllPermissions();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("permissionList",allPermissions);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String savePermission(Permission permission) throws Exception {
        permissionService.savePermission(permission);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findPermissionById.do")
    public ModelAndView findPermissionById(String id) throws Exception {
        Permission permissionById = permissionService.findPermissionById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("permission",permissionById);
        modelAndView.setViewName("permission-show");
        return modelAndView;
    }

    @RequestMapping("/deletePermission.do")
    public String deletePermission(String id) throws Exception{
        permissionService.deletePermissionById(id);
        return "redirect:findAll.do";
    }


}
