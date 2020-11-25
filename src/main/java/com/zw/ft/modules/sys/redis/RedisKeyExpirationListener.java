package com.zw.ft.modules.sys.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName RedisKeyExpirationListener
 * @Description TODO
 * @Author Oliver
 * @Date 2020/10/9 10:23
 * @Version 1.0
 **/
@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {
    @Resource
    RedisService redisService;

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 用户做自己的业务处理即可,注意message.toString()可以获取失效的key
        String expiredKey = message.toString();
        System.out.println(expiredKey);
        redisService.remove(expiredKey);
    }
}
