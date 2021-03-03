package com.atjianyi.service.impl;

import com.atjianyi.dao.RoleMapper;
import com.atjianyi.pojo.Role;
import com.atjianyi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 简一
 * @className RoleServiceImpl
 * @Date 2021/3/2 23:15
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAllRoles() {
        return roleMapper.findAllRoles();
    }
}
