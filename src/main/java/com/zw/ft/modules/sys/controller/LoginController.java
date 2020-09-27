package com.zw.ft.modules.sys.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.zw.ft.common.base.BaseController;
import com.zw.ft.common.base.Constant;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysUserEntity;
import com.zw.ft.modules.sys.redis.RedisService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @Resource
    RedisService redisService;

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
        String token = SecureUtil.md5(RandomUtil.randomString(16));
        redisService.set(username,token, Constant.AN_HOUR);

        return R.ok();
    }

    /*
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
