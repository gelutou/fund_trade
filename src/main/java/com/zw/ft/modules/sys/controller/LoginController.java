package com.zw.ft.modules.sys.controller;

import com.zw.ft.common.base.BaseController;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysUserEntity;
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
        return R.ok();
    }

    /**
     * 功能描述: <br>
     * 〈用户登出〉
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/9/19 22:17
     */
    /*@PostMapping("/logout")
    public R logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return R.ok();
    }*/
    /*@PostMapping("/get_weather")
    public R getWeather(){

    }*/

}
