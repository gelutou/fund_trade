package com.zw.ft.modules.sys.controller;

import com.zw.ft.modules.sys.entity.SysUserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName SysLoginController
 * @Description 系统用户登录控制
 * @Author Oliver
 * @Date 2020/9/15 16:59
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/sys/login")
@Api(value = "用户接口")
public class SysLoginController {
    @ApiOperation(value = "用户控制")
    @GetMapping("/get_user")
    public String hello(@ApiParam(value = "用户实体") String name){
        return name;
    }
}
