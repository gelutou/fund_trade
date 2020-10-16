package com.zw.ft.modules.sys.repository;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zw.ft.modules.sys.entity.SysDepartment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

   /*
    * 功能描述: <br>
    * 〈多表联查,根据公司id查询出公司名字〉
    * @Param:
    * @Return:
    * @Author: savior
    * @Date: 2020/9/23
    */

    @Select("SELECT * FROM sys_department WHERE parent_id = #{parentId} AND dept_level=#{deptLevel}" )
    List<SysDepartment> getSysdept(String parentId,String dept_level);

    /*
     * 功能描述: <br>
     * 〈根据id修改名字〉
     * @Param:
     * @Return:
     * @Author: Oliver
     * @Date: 2020/9/27
     */

    @Update("UPDATE sys_department SET dept_name=#{deptName}, parent_id=#{parentId} WHERE id=#{id}")
    int update(SysDepartment sysDepartment);

}
