package com.zw.ft.modules.sys.controller;

import com.zw.ft.modules.sys.entity.SysUser;
import org.apache.shiro.SecurityUtils;

/*
 * 功能描述: <br>
 * 〈公共的控制器〉
 * @Author: Oliver
 * @Date: 2020/11/11 16:03
 */

public abstract class AbstractController {

    protected SysUser getUser() {
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    protected String getUserName() {
        SysUser sysUer = getUser();
        if (sysUer == null) {
            return "系统管理员";
        }
        return sysUer.getUsername();
    }

    protected Long getUserId() {
        SysUser sysUer = getUser();
        if (sysUer == null) {
            return -1L;
        }
        return sysUer.getId();
    }
}
