package com.zw.ft.modules.sys.repository;

import com.zw.ft.modules.sys.entity.ProvinceCityTownInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * 全国省市县行政区划分信息表 Mapper 接口
 * </p>
 *
 * @author Oliver
 * @since 2021-01-18
 */
@Mapper
public interface ProvinceCityTownInfoMapper extends BaseMapper<ProvinceCityTownInfo> {

    /**
     * 功能描述 : 清空表数据
     * @author Oliver 2021-1-18 16:44
     */
    @Update("TRUNCATE TABLE province_city_town_info")
    void truncate();
}
