package com.zw.ft.modules.sys.repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.modules.sys.entity.SysNeeds;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * <p>
 * 系统需求表 Mapper 接口
 * </p>
 *
 * @author Oliver
 * @since 2020-10-29
 */
@Mapper
public interface SysNeedsMapper extends BaseMapper<SysNeeds> {

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "CREATED_BY", property = "createdBy"),
            @Result(column = "dept_id", property = "deptId"),
            @Result(column = "handler", property = "handler"),
            @Result(column = "confirmer", property = "confirmer"),
            //提出人
            @Result(column = "CREATED_BY", property = "proposer",
                    one = @One(
                            select = "com.zw.ft.modules.sys.repository.SysUserMapper.selectById",
                            fetchType = FetchType.EAGER)
            ),
            //所属部门
            @Result(column = "dept_id", property = "dept",
                    one = @One(
                            select = "com.zw.ft.modules.sys.repository.SysDepartmentMapper.selectById",
                            fetchType = FetchType.EAGER)
            ),
            //处理人
            @Result(column = "handler", property = "handleUser",
                    one = @One(
                            select = "com.zw.ft.modules.sys.repository.SysUserMapper.selectById",
                            fetchType = FetchType.EAGER)
            ),
            //确认人
            @Result(column = "confirmer", property = "confirmerUser",
                    one = @One(
                            select = "com.zw.ft.modules.sys.repository.SysUserMapper.selectById",
                            fetchType = FetchType.EAGER)
            )
    })

    /*
     * 功能描述: <br>
     * 〈查询系统需求列表〉
     * @Param: [page, queryWrapper]
     * @Return: com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.zw.ft.modules.sys.entity.SysNeeds>
     * @Author: Oliver
     * @Date: 2020/10/30 15:33
     */

    @Select("SELECT *,sd.des statusDes FROM sys_needs sy LEFT JOIN (SELECT * FROM sys_dictionary WHERE p_id = (SELECT ID FROM sys_dictionary WHERE des = '系统需求状态')) sd ON sy.status = sd.value ${ew.customSqlSegment}")
    Page<SysNeeds> queryNeedsPage(IPage<SysNeeds> page, @Param("ew") Wrapper<SysNeeds> queryWrapper);
}
