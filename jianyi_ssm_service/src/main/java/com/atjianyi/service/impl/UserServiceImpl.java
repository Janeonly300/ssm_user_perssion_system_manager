package com.atjianyi.service.impl;

import com.atjianyi.dao.UserMapper;
import com.atjianyi.pojo.Role;
import com.atjianyi.pojo.UserInfo;
import com.atjianyi.service.UserService;
import com.atjianyi.utils.PasswordEncoderUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author 简一
 * @className UserServiceImpl
 * @Date 2021/3/1 14:55
 **/
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    @Override
    @Deprecated
    public List<UserInfo> findAllUsers() throws Exception {
        List<UserInfo> allUser = userMapper.findAllUser();
        return allUser;
    }

    /**
     * 分页查询用户
     * @param curPage
     * @param size
     * @return
     * @throws Exception
     */
    @Override
    public List<UserInfo> findAllUsersByPage(int curPage,int size)throws Exception{
        PageHelper.startPage(curPage,size);
        List<UserInfo> allUser = userMapper.findAllUser();
        return allUser;
    }

    /**
     * 保存用户
     * @param userInfo
     */
    @Override
    public void saveUser(UserInfo userInfo) throws Exception {
        //设置uuid
        userInfo.setId(UUID.randomUUID().toString().replace("-",""));
        //设置密码加密
        userInfo.setUserPwd(PasswordEncoderUtils.pwdReversToEncode(userInfo.getUserPwd()));
        //调用dao层存储
        userMapper.insertUser(userInfo);
    }

    /**
     * 查询用户详细信息
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public UserInfo findUserById(String id) throws Exception {
        return userMapper.findUserById(id);
    }

    /**
     * 登陆验证
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        UserInfo userInfo = null;
        try {
            userInfo = userMapper.findUserByName(username);
            System.out.println(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = new User(userInfo.getUserName(),userInfo.getUserPwd(), userInfo.getUserStatus() != 0,true,true,true,getAuthority(userInfo.getRoleList()));
        return user;
    }

    /**
     * 获取用户组
     * @param roleList
     * @return
     */
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roleList){
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roleList) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return authorities;
    }
}
