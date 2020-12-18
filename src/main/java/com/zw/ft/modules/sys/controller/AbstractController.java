package com.zw.ft.modules.sys.controller;

import com.zw.ft.modules.sys.entity.SysDepartment;
import com.zw.ft.modules.sys.entity.SysUser;
import com.zw.ft.modules.sys.service.SysDepartmentService;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/*
 * 功能描述: <br>
 * 〈公共的控制器〉
 * @Author: Oliver
 * @Date: 2020/11/11 16:03
 */

public abstract class AbstractController {

    @Resource
    SysDepartmentService departmentService;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected SysUser getUser() {
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    protected String getUserName() {
        SysUser sysUer = getUser();
        if (sysUer == null) {
            return "admin";
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

    protected SysDepartment getCompany(){
        return departmentService.getDeptByUserId(getUserId());
    }
}
