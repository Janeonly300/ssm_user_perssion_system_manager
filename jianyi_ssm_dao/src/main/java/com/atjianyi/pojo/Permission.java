package com.atjianyi.pojo;

import java.util.List;

/**
 * @author 简一
 * @className Permission
 * @Date 2021/3/1 13:19
 **/
public class Permission {
    private String id;
    private String permissionName;
    private String permissionUrl;
    private List<Role> roles; //权限下的所有角色

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
