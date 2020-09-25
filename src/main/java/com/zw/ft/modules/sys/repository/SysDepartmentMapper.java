package com.zw.ft.modules.sys.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zw.ft.modules.sys.entity.SysCompany;
import com.zw.ft.modules.sys.entity.SysDepartment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 * 系统部门表 Mapper 接口
 * </p>
 *
 * @author Oliver
 * @since 2020-09-20
 */
@Mapper
public interface SysDepartmentMapper extends BaseMapper<SysDepartment> {

    /**
     * @Author savior
     * @Description
     * @Date: 2020/9/23
     */
    @Select("SELECT com_name FROM sys_company sc LEFT JOIN sys_department sd ON sc.id=sd.com_id WHERE sd.com_id =#{comId} GROUP BY com_name" )
    List<SysCompany> getTreeTwo(@Param("comId") String comId);

    @Update("UPDATE  sys_department SET dept_name=#{deptName} WHERE id=#{id}")
    int update(String id,String deptName);

}
