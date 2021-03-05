package com.atjianyi.service;

import com.atjianyi.pojo.Permission;
import com.atjianyi.pojo.Role;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoleService {
    /**
     * 查询所有角色
     * @return
     */
    public List<Role> findAllRoles();

    /**
     * 添加用户角色
     * @param role
     * @throws Exception
     */
    void saveRole(Role role) throws Exception;

    /**
     * 查询角色详情
     * @param roleId
     * @return
     * @throws Exception
     */
    Role findRoleById(String roleId)throws Exception;

    void deleteRoleById(String roleId) throws Exception;

    /**
     * 根据Roleid找出其他权限
     * @param roleId
     * @return
     */
    public List<Permission> findOtherPermission(String roleId) throws Exception;

    /**
     * 为角色添加用户
     * @param roleId
     * @param permissionIds
     */
    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;
}
