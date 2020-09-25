package com.zw.ft.modules.sys.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zw.ft.modules.sys.entity.SysDepartment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
    @Select("select * from sys_department where com_id=#{comId}")
    List<SysDepartment> getTreeTwo(String comId);

  /*  @Insert("")
    List<SysDepartment> insertDept();*/

}
