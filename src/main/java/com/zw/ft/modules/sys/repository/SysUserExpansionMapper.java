package com.zw.ft.modules.sys.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zw.ft.modules.sys.entity.SysUser;
import com.zw.ft.modules.sys.entity.SysUserExpansion;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@description: 人员扩展信息
 *@author:  Oliver
 *@date  2020/9/10
 */
@Repository
public interface SysUserExpansionMapper extends BaseMapper<SysUserExpansion> {

    @Select("SELECT * FROM sys_user_expansion")
    List<SysUserExpansion> getAllUserExpansions();
}
