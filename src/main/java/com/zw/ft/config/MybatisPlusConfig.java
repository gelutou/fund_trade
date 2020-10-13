package com.zw.ft.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName MybatisPlusConfig
 * @Description MybatisPlusConfig
 * @Author Oliver
 * @Date 2020/8/14 14:08
 * @Version 1.0
 **/
@MapperScan("com.zw.ft.modules.*.repository")
@EnableTransactionManagement
@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
public class MybatisPlusConfig {

    /**
     *@description: 乐观锁插件
     */
    @Bean
    public OptimisticLockerInnerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInnerInterceptor();
    }

    @Bean
    public PaginationInterceptor  paginationInterceptor() {
        return new PaginationInterceptor ();
    }

}
