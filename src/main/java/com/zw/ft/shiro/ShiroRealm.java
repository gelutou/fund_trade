package com.zw.ft.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zw.ft.modules.sys.entity.SysRoleEntity;
import com.zw.ft.modules.sys.entity.SysUserEntity;
import com.zw.ft.modules.sys.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName ShiroRealm
 * @Author Oliver
 * @Date 2020/9/19 14:37
 * @Version 1.0
 **/
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    SysUserService sysUserService;
    /**
     * @Author Oliver
     * @Description 权限认证
     * @Date 14:43 2020/9/19
     * @Param [authenticationToken]
     * @return org.apache.shiro.authc.AuthenticationInfo
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前登录信息
        Subject subject = SecurityUtils.getSubject();
        //获取当前登录用户信息
        SysUserEntity principal = (SysUserEntity) subject.getPrincipal();
        System.out.println("principal = " + principal);
        //设置角色
        QueryWrapper<SysUserEntity> userEntityQueryWrapper = new QueryWrapper<>();
        userEntityQueryWrapper.eq("id",principal.getId());
        List<SysUserEntity> userAllMessage = sysUserService.getUserAllMessage(userEntityQueryWrapper);
        List<SysRoleEntity> roles = userAllMessage.get(0).getRoles();

        Set<String> roleIdSet = new LinkedHashSet<>();
        for(SysRoleEntity roleEntity : roles){
            roleIdSet.add(roleEntity.getId().toString());
        }
        //设置角色
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roleIdSet);
        //设置权限
        //simpleAuthorizationInfo.addStringPermission();
        return null;
    }

    /**
     * @Author Oliver
     * @Description 角色认证
     * @Date 14:43 2020/9/19
     * @Param [authenticationToken]
     * @return org.apache.shiro.authc.AuthenticationInfo
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        System.out.println("usernamePasswordToken = " + usernamePasswordToken);
        QueryWrapper<SysUserEntity> entityQueryWrapper = new QueryWrapper<>();
        entityQueryWrapper.eq("username",usernamePasswordToken.getUsername());
        SysUserEntity currentUser = sysUserService.getOne(entityQueryWrapper);

        //验证账号
        if(currentUser != null){
            //验证密码
            return new SimpleAuthenticationInfo(currentUser,currentUser.getPassword(),getName());
        }
        return null;
    }
}
