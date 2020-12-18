package com.zw.ft.modules.sys.repository;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.modules.sys.entity.SysCargoInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author savior
 * @Description 货品信息表 Mapper 接口
 * @Date: 2020/11/19
 */
@DS("fundTrade")
@Mapper
public interface SysCargoInfoMapper extends BaseMapper<SysCargoInfo> {

    /**
     * @Author savior
     * @Description 分页查询货品信息
     * @Date: 2020/11/19
     */
    @Select("SELECT sci.*,dice.des,scc.category_name FROM sys_cargo_info sci " +
            "LEFT JOIN (SELECT * FROM sys_dictionary " +
            "WHERE p_id = (SELECT ID FROM sys_dictionary WHERE name = 'CARGO_UNIT' AND value IS NULL)) dice ON sci.cargo_unit=dice.value " +
            "LEFT JOIN sys_cargo_category scc ON sci.category_pkid=scc.ID " +
            "${ew.customSqlSegment}")
    Page<SysCargoInfo> queryCargoInfo(Page<SysCargoInfo> page, @Param("ew") QueryWrapper<SysCargoInfo> queryWrapper);

}
