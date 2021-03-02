package com.atjianyi.service;

import com.atjianyi.pojo.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    List<UserInfo> findAllUsers() throws Exception;

    /**
     * 添加用户
     * @param userInfo
     */
    void saveUser(UserInfo userInfo) throws Exception;

}
