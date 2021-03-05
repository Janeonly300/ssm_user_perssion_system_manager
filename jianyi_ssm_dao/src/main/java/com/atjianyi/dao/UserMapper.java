package com.atjianyi.dao;

import com.atjianyi.pojo.Role;
import com.atjianyi.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
     UserInfo findUserByName(String username) throws Exception;

    /**
     * 查询所有用户
     * @return
     */
    List<UserInfo> findAllUser() throws Exception;

    /**
     * 添加用户
     */
    void insertUser(UserInfo userInfo) throws Exception;


    /**
     * 根据Id查询用户信息
     * @return
     */
    UserInfo findUserById(String userId) throws Exception;

    /**
     * 根据用户id查询其不拥有的角色
     * @param userId
     * @return
     */
    List<Role> selectOtherRoles(String userId);

    /**
     * 为用户添加角色
     * @param userId
     * @param roleId
     */
    void insertRolesToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
