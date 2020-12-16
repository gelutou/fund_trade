package com.zw.ft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @description: 启动类
 * @author: Oliver
 * @date 2020/9/9
 */
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class FundTradeApplication {
    public static void main(String[] args) {
        SpringApplication.run(FundTradeApplication.class, args);
    }
}
