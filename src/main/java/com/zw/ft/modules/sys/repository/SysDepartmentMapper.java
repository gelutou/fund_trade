package com.zw.ft.modules.sys.repository;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.modules.sys.entity.SysDepartment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 系统部门表 Mapper 接口
 * </p>
 *
 * @author Oliver
 * @since 2020-10-16
 */
@DS("fundTrade")
@Mapper
public interface SysDepartmentMapper extends BaseMapper<SysDepartment> {


    /**
     * @Author savior
     * @Description 多表联查, 根据公司id查询出公司名字
     * @Date: 2020/9/23
     */
    @Select("SELECT sd.*,sc.com_name FROM sys_department sd LEFT JOIN sys_company sc ON sc.id = sd.com_id WHERE sd.com_id = #{comId} AND DELETED=0")
    List<SysDepartment> getCompanyNameBesomId(@Param("comId") String comId);

    /*
     * 功能描述: <br>
     * 〈查询人员的部门〉
     * @Author: Oliver
     * @Date: 2020/11/3 14:34
     */

    @Select("SELECT * FROM sys_department sd,rel_user_department rud WHERE sd.id = rud.dept_id AND rud.user_id = #{userId}")
    SysDepartment getDeptByUserId(@Param("userId") long userId);

}
