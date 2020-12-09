package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_user")
@Data
public class SysUser extends BaseEntity {
    private static final long serialVersionUID = -127682095331146479L;
    /**
     * @description: 用户名
     */
    @NotEmpty(message = "登录账号不能为空")
    @Length(min = 5, max = 16, message = "账号长度为 5-16 位")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "账号内容只能是数字和字母")
    private String username;
    /**
     * @description: 密码
     */
    @NotEmpty(message = "密码不能为空")
    @Length(min = 5, max = 16, message = "密码长度为 5-16 位")
    private String password;
    /**
     * @description: 姓名
     */
    @NotEmpty(message = "姓名不能为空")
    private String realname;
    /**
     * @description: 性别 0 男 1 女
     */
    @NotEmpty(message = "性别不能为空")
    private Integer gender;

    /**
     * @description: 数据来源 0资金 1商贸
     */
    private Integer fundOrTrade;

    /**
     * 旧的部门PKID，只用于合并数据，系统上线后删除
     */
    private String oldPkidWilldel;

    /**
     * @description: 角色集合
     */
    @TableField(exist = false)
    private List<SysRole> roles;

    /**
     * @description: 用户详细信息
     */
    @TableField(exist = false)
    private SysUserExpansion exception;

}
