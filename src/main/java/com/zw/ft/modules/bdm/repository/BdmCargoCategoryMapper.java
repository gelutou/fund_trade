package com.zw.ft.modules.bdm.repository;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zw.ft.modules.bdm.entity.BdmCargoCategory;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 货品分类表 Mapper 接口
 * </p>
 *
 * @author Savior
 * @since 2020-11-30
 */
@DS("fundTrade")
@Mapper
public interface BdmCargoCategoryMapper extends BaseMapper<BdmCargoCategory> {

}
