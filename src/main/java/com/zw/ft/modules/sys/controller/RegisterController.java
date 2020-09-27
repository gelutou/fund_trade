package com.zw.ft.modules.sys.controller;

import com.zw.ft.modules.sys.service.SysUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName RegisterController
 * @Description 注册控制器
 * @Author Oliver
 * @Date 2020/9/19 23:20
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/sys/")
public class RegisterController {

    @Resource
    SysUserService sysUserService;
    /**
     * 功能描述: <br>
     * 〈用户注册，管理员添加用户〉
     * @Param: [username, password]
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/9/19 23:23
     */
    /*@PostMapping(value = "/register")
    public R register(String username,String password){
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setUsername(username);
        sysUserEntity.setCreatedBy(1L);
        sysUserEntity.setUpdatedBy(1L);
        sysUserEntity.setPassword(new SimpleHash(
                //加密方式
                "MD5",
                //要加密的密码
                password,
                //盐
                null,
                //加密次数
                1024
        ).toString());
        sysUserService.save(sysUserEntity);
        return R.ok();
    }*/
}
