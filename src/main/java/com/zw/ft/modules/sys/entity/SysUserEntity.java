package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * @ClassName SysUser
 * @Description 系统用户基本信息实体
 * @Author Oliver
 * @Date 2020/9/9 16:50
 * @Version 1.0
 **/
@TableName(value = "sys_user")
public class SysUserEntity extends BaseEntity {
    private static final long serialVersionUID = -127682095331146479L;

    /**
     *@description: 用户名
     */
    @NotEmpty(message = "登录账号不能为空")
    @Length(min = 5,max = 16,message = "账号长度为 5-16 位")
    @Pattern(regexp = "^[A-Za-z0-9]+$",message = "账号内容只能是数字和字母")
    private String userName;
    /**
     *@description: 密码
     */
    @NotEmpty(message = "密码不能为空")
    @Length(min = 5,max = 16,message = "密码长度为 5-16 位")
    private String password;
    /**
     *@description: 姓名
     */
    @NotEmpty(message = "姓名不能为空")
    private String realName;
    /**
     *@description: 性别 0 男 1 女
     */
    @NotEmpty(message = "性别不能为空")
    private Integer gender;

    /**
     *@description: 角色集合
     */
    private List<SysRoleEntity> roles;

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

    public List<SysRoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRoleEntity> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", gender=" + gender +
                ", roles=" + roles +
                '}';
    }
}
