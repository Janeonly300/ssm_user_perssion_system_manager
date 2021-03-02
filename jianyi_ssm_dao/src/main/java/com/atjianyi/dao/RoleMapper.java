package com.atjianyi.dao;

import com.atjianyi.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 简一
 * @className RoleMapper
 * @Date 2021/3/1 19:09
 * 角色信息查询
 **/
@Repository
public interface RoleMapper {

    /**
     * 根据用户id查询角色
     * @param userId
     * @return
     */
    public List<Role> findRolesByUserId(String userId);
}
