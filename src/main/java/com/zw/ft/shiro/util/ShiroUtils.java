package com.zw.ft.shiro.util;

import com.zw.ft.entity.sys.SysUser;
import com.zw.ft.shiro.service.MyShiroRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
/**
 *@description: shiro工具类
 *@author:  Oliver
 *@date  2020/9/10
 */
public class ShiroUtils {

    private ShiroUtils(){}
    
    /**
     *@description: 获取shiro subject
     *@author:  Oliver
     *@date  2020/9/10
     */
    public static Subject getSubjct()
    {
        return SecurityUtils.getSubject();
    }

    /**
     *@description: 获取登录session
     *@author:  Oliver
     *@date  2020/9/10
     */
    public static Session getSession()
    {
        return SecurityUtils.getSubject().getSession();
    }

    /**
     *@description: 退出登录
     *@author:  Oliver
     *@date  2020/9/10
     */
    public static void logout()
    {
        getSubjct().logout();
    }

    /**
     *@description: 获取登录用户model
     *@author:  Oliver
     *@date  2020/9/10
     */
    public static SysUser getUser()
    {
        SysUser user = null;
        Object obj = getSubjct().getPrincipal();
        if (StringUtils.isNotNull(obj))
        {
            user = new SysUser();
            BeanUtils.copyBeanProp(user, obj);
        }
        return user;
    }
    
    /**
     *@description: set用户
     *@author:  Oliver
     *@date  2020/9/10
     */
    public static void setUser(SysUser user)
    {
        Subject subject = getSubjct();
        PrincipalCollection principalCollection = subject.getPrincipals();
        String realmName = principalCollection.getRealmNames().iterator().next();
        PrincipalCollection newPrincipalCollection = new SimplePrincipalCollection(user, realmName);
        // 重新加载Principal
        subject.runAs(newPrincipalCollection);
    }
    /**
     *@description: 清除授权信息
     *@author:  Oliver
     *@date  2020/9/10
     */
    public static void clearCachedAuthorizationInfo(){
        RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        MyShiroRealm realm = (MyShiroRealm) rsm.getRealms().iterator().next();
        realm.clearCachedAuthorizationInfo();
    }

    /**
     *@description: 获取登录用户id
     *@author:  Oliver
     *@date  2020/9/10
     */
    public static String getUserId(){
        SysUser tsysUser = getUser();
        if (tsysUser == null || tsysUser.getId() == null){
            throw new RuntimeException("用户不存在！");
        }
        return tsysUser.getId().toString();
    }
    /**
     *@description: 获取登录用户name
     *@author:  Oliver
     *@date  2020/9/10
     */
    public static String getLoginName(){
        SysUser tsysUser = getUser();
        if (tsysUser == null){
            throw new RuntimeException("用户不存在！");
        }
        return tsysUser.getUserName();
    }
    /**
     *@description: 获取登录用户ip
     *@author:  Oliver
     *@date  2020/9/10
     */
    public static String getIp()
    {
        return getSubjct().getSession().getHost();
    }

    /**
     *@description: 获取登录用户sessionid
     *@author:  Oliver
     *@date  2020/9/10
     */
    public static String getSessionId()
    {
        return String.valueOf(getSubjct().getSession().getId());
    }
}
