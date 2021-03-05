package com.atjianyi.service.impl;

import com.atjianyi.dao.RoleMapper;
import com.atjianyi.pojo.Permission;
import com.atjianyi.pojo.Role;
import com.atjianyi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author 简一
 * @className RoleServiceImpl
 * @Date 2021/3/2 23:15
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 查询所有角色
     * @return
     */
    @Override
    public List<Role> findAllRoles() {
        return roleMapper.findAllRoles();
    }

    /**
     * 添加一个角色
     * @param role
     * @throws Exception
     */
    @Override
    public void saveRole(Role role) throws Exception {
        role.setId(UUID.randomUUID().toString().replace("-",""));
        roleMapper.insertRoles(role); //添加角色
    }

    /**
     * 查询详情信息
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    public Role findRoleById(String roleId) throws Exception {
        Role role = roleMapper.selectRoleById(roleId);
        System.out.println(role);
        return role;
    }

    @Override
    public void deleteRoleById(String roleId) throws Exception {
        //解除角色与用户关联()
        roleMapper.deleteRoleAndUserById(roleId);
        //解除角色与权限的关联()
        roleMapper.deleteRoleAndPermissionById(roleId);
        //删除角色
        roleMapper.deleteRoleById(roleId);
    }

    /**
     * 根据用户id找出其他权限
     * @param roleId
     * @return
     */
    @Override
    public List<Permission> findOtherPermission(String roleId) throws Exception {
        return roleMapper.selectOtherPermissionByRoleId(roleId);
    }

    /**
     * 为角色添加权限
     * @param roleId
     * @param permissionIds
     */
    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception {
        for (String permissionId : permissionIds) {
            roleMapper.insertPermissionToRole(roleId,permissionId);
        }
    }


}
