package com.atjianyi.dao;

import com.atjianyi.pojo.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper {

    /**
     * 根据角色id查询权限
     * @param roleId
     * @return
     */
    List<Permission> findPermissionsByRoleId(String roleId) throws Exception;

    List<Permission> selectAllPermission() throws Exception;

    /**
     * 添加权限
     * @param permission
     */
    void insertPermission(Permission permission);

    /**
     * 查询权限详细
     */
    Permission findPermissionById(String perId) throws Exception;

    /**
     * 根据权限id解除权限与角色之间的关系
     * @param id
     */
    void deletePermissionWithRole(String id);

    /**
     * 根据id删除角色
     * @param id
     */
    void deletePermissionById(String id);
}
