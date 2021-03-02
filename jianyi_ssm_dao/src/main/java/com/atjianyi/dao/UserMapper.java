package com.atjianyi.dao;

import com.atjianyi.pojo.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
     UserInfo findUserByName(String username) throws Exception;
}
