package com.atjianyi.service;

import com.atjianyi.pojo.Permission;

import java.util.List;

public interface PermissionService {
    /**
     * 查询所有权限
     * @return
     */
    List<Permission> findAllPermissions() throws Exception;

    /**
     * 保存权限信息
     * @param permission
     * @throws Exception
     */
    void savePermission(Permission permission) throws Exception;

    Permission findPermissionById(String permissionId) throws Exception;

    /**
     * 删除权限
     * @param id
     */
    void deletePermissionById(String id);
}
