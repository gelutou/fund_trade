package com.zw.ft.modules.sys.service;

import com.zw.ft.modules.sys.entity.SysUserToken;

import java.util.Set;

/**
 * @description: shiro服务
 * @author: Oliver
 * @date 2020/9/27
 * @修改人和其它信息
 */
public interface ShiroService {
    /*
     * 获取用户权限列表
     */
    /*Set<String> getUserPermissions(long userId);*/

    /**
     * @description: 根据token 查询token信息
     * @author: Oliver
     * @date 2020/9/27
     * @修改人和其它信息
     */
    SysUserToken queryByToken(String token);
}
