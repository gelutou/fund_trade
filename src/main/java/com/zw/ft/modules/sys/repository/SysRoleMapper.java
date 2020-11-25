package com.zw.ft.modules.sys.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zw.ft.modules.sys.entity.SysRole;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @description: 角色Mapper
 * @author: Oliver
 * @date 2020/9/10
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {

    @Select("SELECT * FROM sys_role WHERE ${ew.sqlSegment}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "id", property = "users",
                    many = @Many(
                            select = "com.zw.ft.modules.sys.repository.SysUserRepository.getUserListJoinRole"
                    )
            )
    })
    List<SysRole> getUserAllMessage(@Param("ew") QueryWrapper<SysRole> roleQueryWrapper);

    /**
     * @description: 根据roleId查询角色信息集合
     * @param: roleId 角色Id
     * @author: Oliver
     * @date 2020/9/10
     */
    @Select("SELECT * FROM sys_role sr,sys_user_role sur WHERE sr.ID = sur.role_id AND sr.ID = #{roleId}")
    Set<SysRole> getRoleSetJoinUser(@Param("roleId") long roleId);
}
