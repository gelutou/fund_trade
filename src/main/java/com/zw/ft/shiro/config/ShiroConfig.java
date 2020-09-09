package com.zw.ft.shiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.zw.ft.shiro.service.MyShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@description: 权限配置文件,这是shiro的大管家，相当于mybatis里的SqlSessionFactoryBean
 *@author:  Oliver
 *@date  2020/9/9
 */
@Configuration
public class ShiroConfig {

	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(org.apache.shiro.mgt.SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		//登录
		shiroFilterFactoryBean.setLoginUrl("/admin/login");
		//首页
		shiroFilterFactoryBean.setSuccessUrl("/");
		//错误页面，认证不通过跳转
		shiroFilterFactoryBean.setUnauthorizedUrl("/error/403");
		//页面权限控制
		shiroFilterFactoryBean.setFilterChainDefinitionMap(ShiroFilterMapFactory.shiroFilterMap());

		shiroFilterFactoryBean.setSecurityManager(securityManager);
		return shiroFilterFactoryBean;
	}
	
	/**
	 * web应用管理配置
	 * @param shiroRealm shiroRealm
	 * @param cacheManager cacheManager
	 * @param manager manager
	 * @return DefaultWebSecurityManager
	 */
	@Bean
	public DefaultWebSecurityManager securityManager(Realm shiroRealm,CacheManager cacheManager,RememberMeManager manager) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setCacheManager(cacheManager);
		//记住Cookie
		securityManager.setRememberMeManager(manager);
		securityManager.setRealm(shiroRealm);
		securityManager.setSessionManager(sessionManager());
		return securityManager;
	}

	/**
	 * @Description: session过期控制
	 * @return:  DefaultWebSessionManager
	 * @Author: Oliver
	 * @Date: 2020年06月04日
	*/
	@Bean
	public  DefaultWebSessionManager sessionManager() {
		DefaultWebSessionManager defaultWebSessionManager=new DefaultWebSessionManager();
		// 设置session过期时间3600s 毫秒级别
		long timeout=60L*1000*60;
		defaultWebSessionManager.setGlobalSessionTimeout(timeout);
		return defaultWebSessionManager;
	}
	/**
	 * @Description: 加密算法
	 * @return:  HashedCredentialsMatcher
	 * @Author: Oliver
	 * @Date: 2020年06月04日
	*/
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		//采用MD5 进行加密
		hashedCredentialsMatcher.setHashAlgorithmName("MD5");
		//加密次数
		hashedCredentialsMatcher.setHashIterations(1);
		return hashedCredentialsMatcher;
	}
	
	/**
	 * @Description: 记住我的配置
	 * @return:  RememberMeManager
	 * @Author: Oliver
	 * @Date: 2020年06月04日
	*/
	@Bean
	public RememberMeManager rememberMeManager() {
		Cookie cookie = new SimpleCookie("rememberMe");
		//通过js脚本将无法读取到cookie信息
        cookie.setHttpOnly(true);
		//cookie保存一天
        cookie.setMaxAge(60 * 60 * 24);
		CookieRememberMeManager manager=new CookieRememberMeManager();
		manager.setCookie(cookie);
		return manager;
	}

	/**
	 * @Description:  缓存配置
	 * @return:  CacheManager
	 * @Author: Oliver
	 * @Date: 2020年06月04日
	*/
	@Bean
	public CacheManager cacheManager() {
		//使用内存缓存
		return new MemoryConstrainedCacheManager();
	}

	/**
	 * @Description:  配置realm，用于认证和授权
	 * @Param:  hashedCredentialsMatcher
	 * @return:  AuthorizingRealm
	 * @Author: Oliver
	 * @Date: 2020年06月04日
	*/
	@Bean
	public AuthorizingRealm shiroRealm(HashedCredentialsMatcher hashedCredentialsMatcher) {
		MyShiroRealm shiroRealm = new MyShiroRealm();
		//校验密码用到的算法
		shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher);
		return shiroRealm;
	}
	
	/**
	 * @Description:  启用shiro方言，这样能在页面上使用shiro标签
	 * @return: ShiroDialect
	 * @Author: Oliver
	 * @Date: 2020年06月04日
	*/
	@Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
	
	/**
     * 启用shiro注解
     *加入注解的使用，不加入这个注解不生效
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(org.apache.shiro.mgt.SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
