package com.atjianyi.service.impl;

import com.atjianyi.dao.UserMapper;
import com.atjianyi.pojo.Role;
import com.atjianyi.pojo.UserInfo;
import com.atjianyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<UserInfo> findAllUsers() {
        List<UserInfo> allUser = userMapper.findAllUser();
        return allUser;
    }

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
        String password = user.getPassword();
        System.out.println(password);
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roleList){
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roleList) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return authorities;
    }
}
