package com.zw.ft.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;

/**
 * @ClassName SysUser
 * @Description 系统用户基本信息实体
 * @Author Oliver
 * @Date 2020/9/9 16:50
 * @Version 1.0
 **/
@TableName(value = "sys_user")
public class SysUser extends BaseEntity {
    private static final long serialVersionUID = -127682095331146479L;

    /**
     *@description: 用户名
     */
    private String userName;
    /**
     *@description: 密码
     */
    private String password;
    /**
     *@description: 姓名
     */
    private String realName;
    /**
     *@description: 性别 0 男 1 女
     */
    private Integer gender;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", gender=" + gender +
                '}';
    }
}
