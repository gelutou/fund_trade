package com.zw.ft.modules.sys.repository;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.modules.sys.entity.SysCompany;
import com.zw.ft.modules.sys.entity.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *@description: 系统用户Mapper
 *@author:  Oliver
 *@date  2020/9/10
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /*
     * 功能描述: <br>
     * 〈查询部门下人员〉
     * @Param:
     * @Return:
     * @Author: Oliver
     * @Date: 2020/11/24 11:19
     */

    @Select("SELECT id, username,realname, gender, status FROM sys_user WHERE ID IN (SELECT user_id FROM rel_user_department WHERE dept_id = #{deptId}) AND ${ew.SqlSegment}")
    List<SysUser> getUserInDepartment(IPage<SysUser> page,@Param("deptId") long deptId, @Param("ew") QueryWrapper<SysUser> queryWrapper);

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
    List<SysUser> getUserAllMessage(@Param("ew") QueryWrapper<SysUser> sysUserQueryWrapper);
    /**
     *@description: 根据userId查询用户信息集合
     *@param: userId 用户ID
     *@author:  Oliver
     *@date  2020/9/10
     */
    @Select("SELECT * FROM sys_user su,sys_user_role sur WHERE su.ID = sur.user_id AND su.ID = #{userId}")
    List<SysUser> getUserListJoinRole(@Param("userId") long userId);

    @Select("SELECT sp.perms FROM sys_permission_role spr" +
            " LEFT JOIN sys_permission sp on sp.ID = spr.permission_id" +
            " LEFT JOIN sys_user_role sur on spr.role_id = sur.id" +
            " WHERE sur.user_id = #{userId}")
    List<String> getUserPerms(@Param("userId") long userId);


    @Select("SELECT *" +
            " FROM sys_user su" +
            " LEFT JOIN sys_user_company suc ON su.ID = suc.user_id" +
            " WHERE ${ew.sqlSegment} AND suc.com_id = #{comId}")
    Page<SysUser> queryUsersPageByComAndWrapper(
            Page<SysUser> page
            , @Param("comId") long comId
            , @Param("ew") QueryWrapper<SysUser> userEntityQueryWrapper);
}
