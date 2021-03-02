package com.atjianyi.dao;

import com.atjianyi.pojo.UserInfo;
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
}
