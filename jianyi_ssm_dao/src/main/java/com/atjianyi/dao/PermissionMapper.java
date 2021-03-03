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
}
