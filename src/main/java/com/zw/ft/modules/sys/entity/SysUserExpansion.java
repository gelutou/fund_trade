package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @ClassName SysUserExpansion
 * @Description 用户扩展信息
 * @Author Oliver
 * @Date 2020/9/14 17:45
 * @Version 1.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_user_expansion")
public class SysUserExpansion extends BaseEntity {

    private static final long serialVersionUID = -5209715190641447175L;

    /**
     *@description: 人员ID
     */
    @NotEmpty
    private Long userId;
    /**
     *@description: 手机
     */
    private String mobile;
    /**
     *@description: 办公电话
     */
    private String officePhone;
    /**
     *@description: 邮件
     */
    @Email(message = "邮箱格式不正确")
    private String email;
    /**
     *@description: 生日
     */
    private Date birthday;
    /**
     *@description: 所属省份
     */
    private String province;
    /**
     *@description: 所属城市
     */
    private String city;
    /**
     *@description: 详细信息
     */
    private String address;
    /**
     *@description: 微信号
     */
    private String wechat;
    /**
     *@description: QQ号
     */
    private String qq;
}
