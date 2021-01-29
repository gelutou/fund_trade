package com.zw.ft.modules.bdm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * <p>
 * 货品价格扩展信息表
 * </p>
 *
 * @author Savior
 * @since 2020-12-08
 */
@TableName(value = "bdm_cargo_month_price")
@EqualsAndHashCode(callSuper = true)
@Data
public class BdmCargoMonthPrice extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 客商id
     */
    private Long cusPkid;

    /**
     * 货品类别ID
     */
    @TableField("CARGO_CATEGORY_PKID")
    private Integer cargoCategoryPkid;

    /**
     * 一月价格
     */
    @TableField("JANUARY_PRICE")
    private BigDecimal januaryPrice;

    /**
     * 二月价格
     */
    @TableField("FEBRUARY_PRICE")
    private BigDecimal februaryPrice;

    /**
     * 三月价格
     */
    @TableField("MARCH_PRICE")
    private BigDecimal marchPrice;

    /**
     * 四月价格
     */
    @TableField("APRIL_PRICE")
    private BigDecimal aprilPrice;

    /**
     * 五月价格
     */
    @TableField("MAY_PRICE")
    private BigDecimal mayPrice;

    /**
     * 六月价格
     */
    @TableField("JUNE_PRICE")
    private BigDecimal junePrice;

    /**
     * 七月价格
     */
    @TableField("JULY_PRICE")
    private BigDecimal julyPrice;

    /**
     * 八月价格
     */
    @TableField("AUGUST_PRICE")
    private BigDecimal augustPrice;

    /**
     * 九月价格
     */
    @TableField("SEPTEMBER_PRICE")
    private BigDecimal septemberPrice;

    /**
     * 十月价格
     */
    @TableField("OCTOBER_PRICE")
    private BigDecimal octoberPrice;

    /**
     * 十一月价格
     */
    @TableField("NOVEMBER_PRICE")
    private BigDecimal novemberPrice;

    /**
     * 十二月价格
     */
    @TableField("DECEMBER_PRICE")
    private BigDecimal decemberPrice;

    /**
     * 年份
     */
    private String year;
}
