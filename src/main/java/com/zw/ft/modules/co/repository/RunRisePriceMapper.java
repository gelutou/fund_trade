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


    /**
     * @Author savior
     * @Description 各个公司加价档案列表
     * @Date: 2020/11/11
     */
    @Select("select scy.id,scy.com_name,scy.city,dice.des,pi.fixed,pi.rise_price from sys_company scy " +
            "LEFT JOIN run_rise_price pi ON scy.id=pi.com_id " +
            "LEFT JOIN (SELECT * FROM sys_dictionary " +
            "WHERE p_id = (SELECT ID FROM sys_dictionary WHERE name = 'RUN_RISE' AND value IS NULL)) dice ON pi.fixed = dice.value " +
            "${ew.customSqlSegment}")
    Page<RunRisePrice> queryRunRisePrice(Page<RunRisePrice> page, @Param("ew") QueryWrapper<RunRisePrice> queryWrapper);
}
