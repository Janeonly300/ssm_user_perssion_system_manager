package com.atjianyi.service.impl;

import com.atjianyi.dao.RoleMapper;
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


}
