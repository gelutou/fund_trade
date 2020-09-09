package com.zw.ft.shiro.service;

import com.alibaba.fastjson.JSONObject;
import com.fc.mapper.custom.PermissionDao;
import com.fc.mapper.custom.RoleDao;
import com.fc.mapper.custom.TsysUserDao;
import com.fc.model.auto.TsysPermission;
import com.fc.model.auto.TsysRole;
import com.fc.model.auto.TsysUser;
import com.fc.util.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 身份校验核心类
 * 
 * @ClassName: MyShiroRealm
 * @author fuce
 * @date 2018年8月25日
 *
 */
@Service
public class MyShiroRealm extends AuthorizingRealm {

	@Resource
	private TsysUserDao tsysUserDao;


	/**
	 * @Param:  权限DAO
	*/
	@Resource
	private PermissionDao permissionDao;

	/**
	 * @Param:  角色DAO
	 */
	@Resource
	private RoleDao roleDao ;

	/**
	 * 认证登陆
	 */
	@SuppressWarnings("unused")
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		 //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (token.getPrincipal() == null) {
            return null;
        }
		String username = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		// 通过username从数据库中查找 User对象，如果找到，没找到.
		// 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
		TsysUser userInfo = tsysUserDao.queryUserName(username);
		if (userInfo == null) {
			return null;
		} else{
			return new SimpleAuthenticationInfo(
					// 用户对象
					userInfo,
					// 密码
					userInfo.getPassword(),
					// realm name
					getName()
			);
		}
		
	}
	
	 /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		if(principals == null){
	       throw new AuthorizationException("principals should not be null");  
	    }
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		TsysUser userinfo  = (TsysUser)principals.getPrimaryPrincipal();
		String uid=userinfo.getId();
		List<TsysRole> tsysRoles= roleDao.queryUserRole(uid);
		for(TsysRole userRole:tsysRoles){
			System.out.println(String.format("角色名字：【%s】", JSONObject.toJSON(userRole)));
			//角色id
			String roleId=userRole.getId();
			//添加角色名字
			authorizationInfo.addRole(userRole.getName());
			List<TsysPermission> permissions=permissionDao.queryRoleId(roleId);
			for(TsysPermission p:permissions){
				System.out.println(String.format("角色下面的权限:【%s】", JSONObject.toJSON(p)));
				if(StringUtils.isNotEmpty(p.getPerms())){
					authorizationInfo.addStringPermission(p.getPerms());
				}
			}
		}
		return authorizationInfo;
	}
	
	 /**
     * 清理缓存权限
     */
    public void clearCachedAuthorizationInfo() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
}
