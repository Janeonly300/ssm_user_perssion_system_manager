package com.atjianyi.pojo;

import java.util.List;

/**
 * @author 简一
 * @className UserInfo
 * @Date 2021/2/27 22:44
 * 用户信息表
 **/
public class UserInfo {
    private String id; //uuid
    private String userName;//用户名称
    private String  userEmail; //邮箱
    private String userPwd; // 用户密码
    private String userPhoneNum; //用户电话号码
    private Integer userStatus; //用户状态
    private String userStatusStr; //格式化用户状态
    private List<Role> roleList;//用户角色

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }



    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userPhoneNum='" + userPhoneNum + '\'' +
                ", userStatus=" + userStatus +
                ", userStatusStr='" + userStatusStr + '\'' +
                ", roleList=" + roleList +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserPhoneNum() {
        return userPhoneNum;
    }

    public void setUserPhoneNum(String userPhoneNum) {
        this.userPhoneNum = userPhoneNum;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserStatusStr() {
       if(userStatus !=null){
           if(userStatus==0){
               userStatusStr = "未开启";
           }else{
               userStatusStr = "开启";
           }
       }
       return userStatusStr;
    }

    public void setUserStatusStr(String userStatusStr) {
        this.userStatusStr = userStatusStr;
    }
}
