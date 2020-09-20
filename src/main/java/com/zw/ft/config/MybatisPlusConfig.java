package com.zw.ft.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName MybatisPlusConfig
 * @Description TODO
 * @Author Oliver
 * @Date 2020/8/14 14:08
 * @Version 1.0
 **/
@MapperScan("com.zw.ft.modules.*.repository")
//开启事务管理
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {

    //注册乐观锁插件
    @Bean
    public OptimisticLockerInnerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInnerInterceptor();
    }

    @Bean
    public PaginationInterceptor  paginationInterceptor() {
        return new PaginationInterceptor ();
    }
}
