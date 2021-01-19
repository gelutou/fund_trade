package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 全国省市县行政区划分信息实体
 * </p>
 *
 * @author Oliver
 * @since 2021-01-18
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "province_city_town_info")
@Data
public class ProvinceCityTownInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 数据ID
     */
    private Long dataId;

    /**
     * 省市区名
     */
    private String name;

    /**
     * 父ID
     */
    private Long parentId;

    /**
     * 父名称
     */
    private String parentName;

    /**
     * 区号
     */
    private String areacode;

    /**
     * 邮编
     */
    private String zipcode;

    /**
     * 深度 层级省1市2区3
     */
    private String depth;
}
