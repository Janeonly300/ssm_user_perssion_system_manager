package com.atjianyi.service;

import com.atjianyi.pojo.Role;
import com.atjianyi.pojo.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    @Deprecated
    List<UserInfo> findAllUsers() throws Exception;


    /**
     * 分页查询
     * @param curPage
     * @param size
     * @return
     * @throws Exception
     */
    List<UserInfo> findAllUsersByPage(int curPage,int size) throws Exception;

    /**
     * 添加用户
     * @param userInfo
     */
    void saveUser(UserInfo userInfo) throws Exception;

    /**
     * @param id
     * @return
     */
    UserInfo findUserById(String id) throws Exception;

    /**
     * findOtherRoles
     * @param id
     * @return
     */
    List<Role> findOtherRoles(String id);

    void saveRolesToUser(String userId,String[] roleIds);
}
