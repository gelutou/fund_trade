package com.zw.ft.modules.sys.entity;

import com.zw.ft.common.base.BaseEntity;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;

/**
 * <p>
 *  系统用户token表
 * </p>
 *
 * @author Oliver
 * @since 2020-09-25
 */
public class SysUserToken extends BaseEntity {

    private static final long serialVersionUID = 5631168085771768786L;
    /**
     * 用户
     */
    private Integer userId;

    /**
     * token
     */
    private String token;

    /**
     * token过期时间
     */
    private Date tokenExpireTime;

    /**
     * token更新时间
     */
    private Date tokenUpdateTime;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getTokenExpireTime() {
        return tokenExpireTime;
    }

    public void setTokenExpireTime(Date tokenExpireTime) {
        this.tokenExpireTime = tokenExpireTime;
    }

    public Date getTokenUpdateTime() {
        return tokenUpdateTime;
    }

    public void setTokenUpdateTime(Date tokenUpdateTime) {
        this.tokenUpdateTime = tokenUpdateTime;
    }

    @Override
    public String toString() {
        return "SysUserToken{" +
        "userId=" + userId +
        ", token=" + token +
        ", tokenExpireTime=" + tokenExpireTime +
        ", tokenUpdateTime=" + tokenUpdateTime +
        "}";
    }
}
