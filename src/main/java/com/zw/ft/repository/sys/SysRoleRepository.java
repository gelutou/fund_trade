package com.zw.ft.repository.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zw.ft.entity.sys.SysRole;
import com.zw.ft.entity.sys.SysUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@description: 角色Mapper
 *@author:  Oliver
 *@date  2020/9/10
 */
@Repository
public interface SysRoleRepository extends BaseMapper<SysRole> {

    @Select("SELECT * FROM sys_role WHERE ${qw.sqlSegment}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "id",property = "users",
                many = @Many(
                        select = "com.zw.ft.repository.sys.SysUserRepository.getUserList"
                )
            )
    })
    List<SysRole> getAllRoleListByWrapper(@Param("qw") QueryWrapper<SysRole> roleQueryWrapper);
    /**
     *@description: 根据roleId查询角色信息集合
     *@param: roleId 角色Id
     *@author:  Oliver
     *@date  2020/9/10
     */
    @Select("SELECT * FROM sys_role sr,sys_user_role sur WHERE sr.ID = sur.role_id AND sr.ID = #{roleId}")
    List<SysUser> getRoleList(@Param("roleId") long roleId);
}
