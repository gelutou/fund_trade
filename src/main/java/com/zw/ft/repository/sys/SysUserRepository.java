package com.zw.ft.repository.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zw.ft.entity.sys.SysRole;
import com.zw.ft.entity.sys.SysUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@description: 系统用户Mapper
 *@author:  Oliver
 *@date  2020/9/10
 */
@Repository
public interface SysUserRepository extends BaseMapper<SysUser> {

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
                        select = "com.zw.ft.repository.sys.SysRoleRepository.getRoleList"
                )
            )
    })
    List<SysUser> getMainUserListByWrapper(@Param("qw") QueryWrapper<SysUser> sysUserQueryWrapper);
    /**
     *@description: 根据userId查询用户信息集合
     *@param: userId 用户ID
     *@author:  Oliver
     *@date  2020/9/10
     */
    @Select("SELECT * FROM sys_user su,sys_user_role sur WHERE su.ID = sur.user_id AND su.ID = #{userId}")
    List<SysUser> getUserList(@Param("userId") long userId);
}
