package com.zw.ft.modules.sys.repository;

import com.zw.ft.modules.sys.entity.RelUserDepartment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 人员部门关系表  Mapper 接口
 * </p>
 *
 * @author Oliver
 * @since 2020-11-03
 */
@Mapper
public interface RelUserDepartmentMapper extends BaseMapper<RelUserDepartment> {

    /*
     * 功能描述: <br>
     * 〈获取部门下所有人员ID〉
     * @Param:
     * @Return:
     * @Author: Oliver
     * @Date: 2020/11/30 11:39
     */

    @Select("SELECT user_id FROM rel_user_department WHERE dept_id IN (#{deptIds})")
    List<Long> getUserIdInDept(@Param("deptIds") String deptIds);

}
