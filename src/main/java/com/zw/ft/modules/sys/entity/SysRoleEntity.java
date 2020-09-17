package com.zw.ft.modules.sys.entity;

import com.zw.ft.common.base.BaseEntity;

import java.util.List;

/**
 * @ClassName SysRole
 * @Description 系统角色实体
 * @Author Oliver
 * @Date 2020/9/10 9:36
 * @Version 1.0
 **/
public class SysRoleEntity extends BaseEntity {

    private static final long serialVersionUID = 2102161014072264011L;
    /**
     *@description: 角色编号
     */
    private String roleCode;
    /**
     *@description: 角色编号
     */
    private String roleName;

    /**
     *@description: 用户集合
     */
    private List<SysUserEntity> users;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<SysUserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<SysUserEntity> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "roleCode='" + roleCode + '\'' +
                ", roleName='" + roleName + '\'' +
                ", users=" + users +
                '}';
    }
}
