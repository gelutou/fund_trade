package com.zw.ft.sys;

import com.zw.ft.modules.sys.redis.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * @ClassName RedisTest
 * @Description RedisTest
 * @Author Oliver
 * @Date 2020/9/27 14:15
 * @Version 1.0
 **/
@SpringBootTest
public class RedisTest {

    @Resource
    RedisService redisService;

    @Test
    public void sets() throws InterruptedException {
        //验证码绑定手机号并存储到redis
        redisService.set("17710205730","1111",5);

        //首先比对验证码是否失效
        String redisauthcode= redisService.get("17710205730"); //传入tonkenId返回redis中的value
        System.out.println("redisauthcode = " + redisauthcode);
    }

}
