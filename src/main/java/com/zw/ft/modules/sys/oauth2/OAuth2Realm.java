package com.zw.ft.modules.sys.oauth2;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zw.ft.modules.sys.entity.SysUser;
import com.zw.ft.modules.sys.entity.SysUserToken;
import com.zw.ft.modules.sys.redis.RedisService;
import com.zw.ft.modules.sys.service.ShiroService;
import com.zw.ft.modules.sys.service.SysUserTokenService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description: 认证授权
 * @author: Oliver
 * @date 2020/9/28
 * @修改人和其它信息
 */
@Component
public class OAuth2Realm extends AuthorizingRealm {

    @Resource
    private ShiroService shiroService;
    @Resource
    SysUserTokenService tokenService;
    @Resource
    RedisService redisService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        /*SysUserEntity user = (SysUserEntity)principals.getPrimaryPrincipal();
        Long userId = user.getUserId();

        //用户权限列表
        Set<String> permsSet = shiroService.getUserPermissions(userId);*/
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        /*info.setStringPermissions(permsSet);*/
        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accessToken = token.getPrincipal().toString();

        QueryWrapper<SysUserToken> tokenQueryWrapper = new QueryWrapper<>();
        tokenQueryWrapper.eq("token", accessToken);
        SysUserToken tokenUserByToken = tokenService.getTokenUserByToken(tokenQueryWrapper);
        SysUser user = tokenUserByToken.getUser();
        String username = user.getUsername();
        String rKey = redisService.get(username);
        if (rKey == null) {
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }
        return new SimpleAuthenticationInfo(user, accessToken, getName());
    }
}
