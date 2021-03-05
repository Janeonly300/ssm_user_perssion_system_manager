package com.atjianyi.dao;

import com.atjianyi.pojo.Permission;
import com.atjianyi.pojo.Role;
import org.apache.ibatis.annotations.Param;
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
     * 查询所有角色
     * @return
     */
    public List<Role> findAllRoles();

    /**
     * 根据用户id查询角色
     * @param userId
     * @return
     */
    public List<Role> findRolesByUserId(String userId) throws Exception;

    /**
     * 根据用户id查询角色(详情查询：包括查询权限信息)
     * @param userId
     * @return
     * @throws Exception
     */
    List<Role> findRolesAndPermissions(String userId) throws Exception;

    /**
     * 添加一个角色
     * @param role
     */
    void insertRoles(Role role) throws Exception;

    /**
     * 查询角色
     * @param roleId
     * @return
     */
    Role selectRoleById(String roleId) throws Exception;

    /**
     * 解除role与User关联
     * @param roleId
     */
    void deleteRoleAndUserById(String roleId) throws Exception;

    /**
     * 解除role与permission的关联
     * @param roleId
     */
    void deleteRoleAndPermissionById(String roleId)throws Exception;

    /**
     * 根据Id删除role
     * @param roleId
     */
    void deleteRoleById(String roleId)throws Exception;

    List<Permission> selectOtherPermissionByRoleId(String roleId)throws Exception;

    void insertPermissionToRole(@Param("roleId") String roleId,@Param("permissionId") String permissionId) throws Exception;
}
