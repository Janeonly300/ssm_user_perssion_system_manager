package com.atjianyi.service;

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
}
