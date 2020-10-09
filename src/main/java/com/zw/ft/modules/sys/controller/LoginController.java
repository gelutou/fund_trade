package com.zw.ft.modules.sys.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zw.ft.common.base.BaseController;
import com.zw.ft.common.base.Constant;
import com.zw.ft.common.utils.R;
import com.zw.ft.modules.sys.entity.SysUser;
import com.zw.ft.modules.sys.entity.SysUserToken;
import com.zw.ft.modules.sys.oauth2.OAuth2Token;
import com.zw.ft.modules.sys.redis.RedisService;
import com.zw.ft.modules.sys.service.SysUserService;
import com.zw.ft.modules.sys.service.SysUserTokenService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @Resource
    SysUserService sysUserService;
    @Resource
    SysUserTokenService sysUserTokenService;
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
        //判断有无此用户
        QueryWrapper<SysUser> entityQueryWrapper = new QueryWrapper<>();
        entityQueryWrapper.eq("username",username);
        SysUser one = sysUserService.getOne(entityQueryWrapper);
        if(one == null){
            return R.error("无此用户");
            //判断密码是否相等
        }else if (new Sha256Hash(password, username).toHex(

        ).equals(one.getPassword())){
            //判断token是否过期
            String token = redisService.get(username);
            String newToken;
            if(token == null){
                newToken = SecureUtil.md5(RandomUtil.randomString(16));
                redisService.set(username,newToken, Constant.AN_DAY);
            }else {
                newToken = token;
            }

            //将token存进数据库
            QueryWrapper<SysUserToken> tokenQueryWrapper = new QueryWrapper<>();
            tokenQueryWrapper.eq("user_id",one.getId());
            SysUserToken userToken = sysUserTokenService.getOne(tokenQueryWrapper);
            if(userToken == null){
                userToken = new SysUserToken();
                userToken.setUserId(one.getId());
                userToken.setToken(newToken);
                sysUserTokenService.save(userToken);
            }else if(token == null){
                SysUserToken updateToke = new SysUserToken();
                updateToke.setId(userToken.getId());
                updateToke.setUserId(userToken.getUserId());
                updateToke.setToken(newToken);
                sysUserTokenService.updateById(updateToke);
            }
            OAuth2Token oAuth2Token = new OAuth2Token(token);
            SecurityUtils.getSubject().login(oAuth2Token);
            return R.ok(token);
        }else {
            return R.error("密码错误");
        }
    }

    /*
     * 功能描述: <br>
     * 〈用户登出〉
     * @Return: com.zw.ft.common.utils.R
     * @Author: Oliver
     * @Date: 2020/9/19 22:17
     */

/*    @PostMapping("/logout")
    public R logout(){
        return R.ok("444");
    }*/
    /*@PostMapping("/get_weather")
    public R getWeather(){

    }*/


    @PostMapping("/logout")
    public R logout(){
        SecurityUtils.getSubject().logout();
        return R.ok();
    }


}
