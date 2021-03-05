package com.atjianyi.service.impl;

import com.atjianyi.dao.PermissionMapper;
import com.atjianyi.pojo.Permission;
import com.atjianyi.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author 简一
 * @className PermissionServiceImpl
 * @Date 2021/3/3 15:24
 **/
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findAllPermissions() throws Exception {
        return permissionMapper.selectAllPermission();
    }

    /**
     * 保存权限信息
     * @param permission
     * @throws Exception
     */
    @Override
    public void savePermission(Permission permission) throws Exception {
        //添加uuid
        permission.setId(UUID.randomUUID().toString().replace("-",""));
        permissionMapper.insertPermission(permission);
    }

    /**
     * 查询权限详细信息
     * @param permissionId
     * @return
     * @throws Exception
     */
    @Override
    public Permission findPermissionById(String permissionId) throws Exception {
        return permissionMapper.findPermissionById(permissionId);
    }

    /**
     * 删除权限
     * @param id
     */
    @Override
    public void deletePermissionById(String id) {
        //解除权限与角色之间的关系
        permissionMapper.deletePermissionWithRole(id);
        //删除权限
        permissionMapper.deletePermissionById(id);
    }


}
