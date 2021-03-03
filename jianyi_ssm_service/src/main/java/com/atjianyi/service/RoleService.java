package com.atjianyi.service;

import com.atjianyi.pojo.Role;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoleService {
    public List<Role> findAllRoles();
}
