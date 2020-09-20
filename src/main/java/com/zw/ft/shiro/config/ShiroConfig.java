package com.zw.ft.shiro.config;

import com.zw.ft.shiro.ShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName ShiroConfig
 * @Description ShiroConfig
 * @Author Oliver
 * @Date 2020/9/19 14:52
 * @Version 1.0
 **/
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultSecurityManager defaultSecurityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(defaultSecurityManager);

        factoryBean.setLoginUrl("/login");
        /*
         * anon : 无需认证
         * authc : 必须登录
         * user : 不一定通过认证，只要曾被shiro记录，比如记住我
         */
        Map<String,String> map = new LinkedHashMap<>();
        map.put("/main","authc");
        map.put("/manage","perms[manage]");
        map.put("/admin","perms[admin]");
        factoryBean.setFilterChainDefinitionMap(map);
        return factoryBean;
    }
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("shiroRealm") ShiroRealm shiroRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(shiroRealm);
        return manager;
    }
    @Bean
    public ShiroRealm shiroRealm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher matcher){
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setAuthorizationCachingEnabled(false);
        shiroRealm.setCredentialsMatcher(matcher);
        return shiroRealm;
    }
    /**
     * 功能描述: <br>
     * 〈加密方式：进行1024次MD5加密〉
     * @Param: []
     * @Return: org.apache.shiro.authc.credential.HashedCredentialsMatcher
     * @Author: Oliver
     * @Date: 2020/9/19 22:55
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //指定加密方式为MD5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //加密次数
        credentialsMatcher.setHashIterations(1024);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }
}
