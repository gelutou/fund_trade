package com.zw.ft.modules.sys.controller;

import com.zw.ft.common.base.BaseController;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysUserEntity;
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
@RequestMapping(value = "/ft/sys/")
public class LoginController extends BaseController {

    /**
     * 功能描述: <br>
     * 〈用户登录〉
     * @Param: [username, password]
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/9/19 22:17
     */
    @PostMapping("/login/{username}/{password}")
    public R login(@PathVariable("username") String username,@PathVariable("password") String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        try {
            subject.login(usernamePasswordToken);
            logger.info("wo 登录了");
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
    /*@PostMapping("/get_weather")
    public R getWeather(){

    }*/

}
