package com.zw.ft.modules.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zw.ft.modules.sys.entity.SysPermissionEntity;
import com.zw.ft.modules.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 *@description: 系统用户服务
 *@author:  Oliver
 *@date  2020/9/15
 */
public interface SysPermissionService extends IService<SysPermissionEntity> {
    /**
     * 功能描述: <br>
     * 〈查询根目录〉
     * @Param: [userId] 用户ID
     * @Return: java.util.List<com.zw.ft.modules.sys.entity.SysPermissionEntity>
     * @Author: Oliver
     * @Date: 2020/9/20 11:10
     */
    List<SysPermissionEntity> getRootMenu(long userId);

    /*
     * 功能描述: <br>
     * 〈查询子菜单〉
     * @Param: [userId]
     * @Return: java.util.List<com.zw.ft.modules.sys.entity.SysPermissionEntity>
     * @Author: Oliver
     * @Date: 2020/9/20 11:11
     */
    List<SysPermissionEntity> getChildMenu(long userId,long parentId);

    /**
     * 功能描述: <br>
     * 〈获取用户的权限〉
     * @Param: [userId]
     * @Return: java.util.Set<java.lang.String>
     * @Author: Oliver
     * @Date: 2020/9/20 12:57
     */
    Set<String> getUserPermissions(long userId);
}
