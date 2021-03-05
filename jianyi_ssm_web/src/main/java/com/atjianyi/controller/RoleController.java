package com.atjianyi.controller;

import com.atjianyi.pojo.Permission;
import com.atjianyi.pojo.Role;
import com.atjianyi.service.RoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/findRoleById.do")
    public ModelAndView findRoleById(String id) throws Exception {
        Role role = roleService.findRoleById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("role", role);
        modelAndView.setViewName("role-show");
        return modelAndView;
    }

    @RequestMapping("/deleteRoleById.do")
    public String deleteRoleById(String id) throws Exception {
        roleService.deleteRoleById(id);
        return "redirect:findAllRoles.do";
    }

    @RequestMapping("/findRoleAndOtherPermission.do")
    public ModelAndView findRoleAndOtherPermission(@RequestParam("id") String roleId) throws Exception {
        //根据角色Id找出role
        Role role = roleService.findRoleById(roleId);
        //根据找出来的role找到其他权限
        List<Permission> permissions = roleService.findOtherPermission(role.getId());
        ModelAndView mv = new ModelAndView();
        mv.addObject("role",role);
        mv.addObject("permissions",permissions);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam("roleId")String roleId,@RequestParam("ids")String[] PermissionIds) throws Exception {
        roleService.addPermissionToRole(roleId,PermissionIds);
        return "redirect:findAllRoles.do";
    }
}
