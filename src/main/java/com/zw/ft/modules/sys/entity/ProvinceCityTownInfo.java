package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * <p>
 * 全国省市县行政区划分信息实体
 * </p>
 *
 * @author Oliver
 * @since 2021-01-18
 */
@TableName(value = "province_city_town_info")
@Data
public class ProvinceCityTownInfo{

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

    @TableField(fill = FieldFill.INSERT)
    private Long createdBy;

    /**
     * @description: 创建时间
     */

    @TableField(fill = FieldFill.INSERT)
    private String createdTime;

    /**
     * @description: 修改人ID
     */

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updatedBy;

    /**
     * @description: 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updatedTime;

    /**
     * @description: 逻辑删除
     */
    @TableLogic
    private Integer deleted;
}
