package com.zw.ft.modules.sys.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zw.ft.modules.sys.entity.SysPermissionEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@description: 权限信息
 *@author:  Oliver
 *@date  2020/9/10
 */
@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermissionEntity> {

    /**
     * 功能描述: <br>
     * 〈查询根目录〉
     * @Param: [userId] 用户ID
     * @Return: java.util.List<com.zw.ft.modules.sys.entity.SysPermissionEntity>
     * @Author: Oliver
     * @Date: 2020/9/20 11:10
     */
    @Select("SELECT sp.menu_name, sp.menu_description, sp.url, sp.is_blank, sp.perms, sp.icon,sp.type" +
            "  FROM sys_permission sp" +
            "  LEFT JOIN sys_permission_role spr on sp.ID = spr.permission_id" +
            "  WHERE spr.role_id IN (select ur.role_id from sys_user_role ur where ur.user_id = #{userId})" +
            "  AND sp.type = 0" +
            "  AND sp.parent_id is null")
    List<SysPermissionEntity> getRootMenu(@Param("userId") long userId);

    /*
     * 功能描述: <br>
     * 〈查询子菜单〉
     * @Param: [userId]
     * @Return: java.util.List<com.zw.ft.modules.sys.entity.SysPermissionEntity>
     * @Author: Oliver
     * @Date: 2020/9/20 11:11
     */
    @Select("SELECT sp.menu_name, sp.menu_description, sp.url, sp.is_blank, sp.perms, sp.icon,sp.type" +
            "  FROM sys_permission sp" +
            "  LEFT JOIN sys_permission_role spr on sp.ID = spr.permission_id" +
            "  WHERE spr.role_id IN (select ur.role_id from sys_user_role ur where ur.user_id = #{userId})" +
            "  AND sp.type = 1" +
            "  AND sp.parent_id = ${parentId}")
    List<SysPermissionEntity> getChildMenu(@Param("userId") long userId,@Param("parentId") long parentId);
}
