package com.zw.ft.modules.sys.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.modules.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@description: 系统用户Mapper
 *@author:  Oliver
 *@date  2020/9/10
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

    /**
     *@description: 查询用户的主要信息，包含角色等
     *@param: sysUserQueryWrapper 条件构造器
     *@author:  Oliver
     *@date  2020/9/10
     */
    @Select("SELECT * FROM sys_user WHERE ${ew.sqlSegment}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "id",property = "roles",
                many = @Many(
                        select = "com.zw.ft.modules.sys.repository.SysRoleRepository.getRoleSetJoinUser"
                )
            )
    })
    List<SysUserEntity> getUserAllMessage(@Param("ew") QueryWrapper<SysUserEntity> sysUserQueryWrapper);
    /**
     *@description: 根据userId查询用户信息集合
     *@param: userId 用户ID
     *@author:  Oliver
     *@date  2020/9/10
     */
    @Select("SELECT * FROM sys_user su,sys_user_role sur WHERE su.ID = sur.user_id AND su.ID = #{userId}")
    List<SysUserEntity> getUserListJoinRole(@Param("userId") long userId);

    @Select("SELECT sp.perms FROM sys_permission_role spr" +
            " LEFT JOIN sys_permission sp on sp.ID = spr.permission_id" +
            " LEFT JOIN sys_user_role sur on spr.role_id = sur.id" +
            " WHERE sur.user_id = #{userId}")
    List<String> getUserPerms(@Param("userId") long userId);


    @Select("SELECT *" +
            " FROM sys_user su" +
            " LEFT JOIN sys_user_company suc ON su.ID = suc.user_id" +
            " WHERE ${ew.sqlSegment} AND suc.com_id = #{comId}")
    Page<SysUserEntity> queryUsersPageByComAndWrapper(
            Page<SysUserEntity> page
            , @Param("comId") long comId
            , @Param("ew") QueryWrapper<SysUserEntity> userEntityQueryWrapper);
}
