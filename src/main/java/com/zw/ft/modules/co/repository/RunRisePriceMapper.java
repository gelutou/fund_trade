package com.zw.ft.modules.co.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zw.ft.modules.co.entity.RunRisePrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 加价档案表 Mapper 接口
 * </p>
 *
 * @author Savior
 * @since 2020-11-11
 */
@Mapper
public interface RunRisePriceMapper extends BaseMapper<RunRisePrice> {
}
