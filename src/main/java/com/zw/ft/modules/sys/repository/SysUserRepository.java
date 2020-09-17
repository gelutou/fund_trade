package com.zw.ft.modules.sys.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface SysUserRepository extends BaseMapper<SysUserEntity> {

    /**
     *@description: 查询用户的主要信息，包含角色等
     *@param: sysUserQueryWrapper 条件构造器
     *@author:  Oliver
     *@date  2020/9/10
     */
    @Select("SELECT * FROM sys_user WHERE ${qw.sqlSegment}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "id",property = "roles",
                many = @Many(
                        select = "com.zw.ft.modules.sys.repository.SysRoleRepository.getRoleList"
                )
            )
    })
    List<SysUserEntity> getMainUserListByWrapper(@Param("qw") QueryWrapper<SysUserEntity> sysUserQueryWrapper);
    /**
     *@description: 根据userId查询用户信息集合
     *@param: userId 用户ID
     *@author:  Oliver
     *@date  2020/9/10
     */
    @Select("SELECT * FROM sys_user su,sys_user_role sur WHERE su.ID = sur.user_id AND su.ID = #{userId}")
    List<SysUserEntity> getUserList(@Param("userId") long userId);
}
