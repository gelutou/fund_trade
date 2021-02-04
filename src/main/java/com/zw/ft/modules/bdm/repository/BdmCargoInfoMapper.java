package com.zw.ft.modules.bdm.repository;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.modules.bdm.entity.BdmCargoInfo;
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
public interface BdmCargoInfoMapper extends BaseMapper<BdmCargoInfo> {

    /**
     * @Author savior
     * @Description 分页查询货品信息
     * @Date: 2020/11/19
     */
    @Select("SELECT bci.*,bcc.name AS categoryName FROM bdm_cargo_info bci " +
            "LEFT JOIN bdm_cargo_category bcc ON bci.category_pkid=bcc.id " +
            "${ew.customSqlSegment}")
    Page<BdmCargoInfo> queryCargoInfo(Page<BdmCargoInfo> page, @Param("ew") QueryWrapper<BdmCargoInfo> queryWrapper);

}
