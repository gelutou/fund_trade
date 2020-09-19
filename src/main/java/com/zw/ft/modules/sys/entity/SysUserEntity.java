package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Set;

/**
 * @ClassName SysUser
 * @Description 系统用户基本信息实体
 * @Author Oliver
 * @Date 2020/9/9 16:50
 * @Version 1.0
 **/
@Api(value = "系统用户实体")
@TableName(value = "sys_user")
public class SysUserEntity extends BaseEntity {
    private static final long serialVersionUID = -127682095331146479L;
    /**
     *@description: 用户名
     */
    @NotEmpty(message = "登录账号不能为空")
    @Length(min = 5,max = 16,message = "账号长度为 5-16 位")
    @Pattern(regexp = "^[A-Za-z0-9]+$",message = "账号内容只能是数字和字母")
    @ApiModelProperty(value = "用户名")
    private String username;
    /**
     *@description: 密码
     */
    @NotEmpty(message = "密码不能为空")
    @Length(min = 5,max = 16,message = "密码长度为 5-16 位")
    @ApiModelProperty(value = "密码")
    private String password;
    /**
     *@description: 姓名
     */
    @NotEmpty(message = "姓名不能为空")
    @ApiModelProperty(value = "真名")
    private String realName;
    /**
     *@description: 性别 0 男 1 女
     */
    @NotEmpty(message = "性别不能为空")
    @ApiModelProperty(value = "性别，0 男 1 女")
    private Integer gender;

    /**
     *@description: 角色集合
     */
    @ApiModelProperty(value = "角色")
    @TableField(exist = false)
    private List<SysRoleEntity> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return "SysUserEntity{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", gender=" + gender +
                ", roles=" + roles +
                '}';
    }
}
