package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;

/**
 * <p>
 *  系统用户token表
 * </p>
 *
 * @author Oliver
 * @since 2020-09-25
 */
@TableName(value = "sys_user_token")
public class SysUserToken extends BaseEntity {

    private static final long serialVersionUID = 5631168085771768786L;
    /**
     * 用户
     */
    private long userId;

    /**
     * token
     */
    private String token;

    /**
     *@description: 用户实体
     */
    @TableField(exist = false)
    private SysUser user;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "SysUserToken{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                ", user=" + user +
                '}';
    }
}
