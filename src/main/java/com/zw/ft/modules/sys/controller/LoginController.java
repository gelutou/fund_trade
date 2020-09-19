package com.zw.ft.modules.sys.controller;

import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysUserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName SysLoginController
 * @Description 系统用户登录控制
 * @Author Oliver
 * @Date 2020/9/15 16:59
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/sys/")
@Api(value = "用户接口")
public class LoginController {
    @ApiOperation(value = "用户控制")
    @GetMapping("/get_user")
    public String hello(@ApiParam(value = "用户实体") String name){
        return name;
    }

    /**
     * 功能描述: <br>
     * 〈用户登录〉
     * @Param: [username, password]
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/9/19 22:17
     */
    @PostMapping("/login")
    public R login(String username,String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        try {
            subject.login(usernamePasswordToken);
            SysUserEntity principal = (SysUserEntity)subject.getPrincipal();
            subject.getSession().setAttribute("user",principal);
        }catch (UnknownAccountException e){
            return R.error("账号不存在");
        }catch (IncorrectCredentialsException e){
            return R.error("密码错误");
        }
        return R.ok();
    }

    /**
     * 功能描述: <br>
     * 〈用户登出〉
     * @Param: [username, password]
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/9/19 22:17
     */
    @PostMapping("/logout")
    public R logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return R.ok();
    }
}
