package com.zw.ft.modules.bdm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 货品分类表
 * </p>
 *
 * @author Savior
 * @since 2020-11-30
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "bdm_cargo_category")
@Data
public class BdmCargoCategory extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -5983812632131343635L;
    /**
     * 货品分类编号
     */
    @Pattern(regexp = "^^[0-9a-zA-Z]+$",message = "请传入正确的货品分类编号：数字和字母",groups = Add.class)
    private String code;

    /**
     * 分类名称
     */
    @NotNull(message = "请传入分类名称",groups = Add.class)
    private String name;

    /**
     * 价格对应ID
     */
    @TableField(exist = false)
    private Long priceId;

    /**
     * ID数组
     */
    @TableField(exist = false)
    private Long[] ids;

    /**
     * 一月价格
     */
    @TableField(exist = false)
    private BigDecimal januaryPrice;

    /**
     * 二月价格
     */
    @TableField(exist = false)
    private BigDecimal februaryPrice;

    /**
     * 三月价格
     */
    @TableField(exist = false)
    private BigDecimal marchPrice;

    /**
     * 四月价格
     */
    @TableField(exist = false)
    private BigDecimal aprilPrice;

    /**
     * 五月价格
     */
    @TableField(exist = false)
    private BigDecimal mayPrice;

    /**
     * 六月价格
     */
    @TableField(exist = false)
    private BigDecimal junePrice;

    /**
     * 七月价格
     */
    @TableField(exist = false)
    private BigDecimal julyPrice;

    /**
     * 八月价格
     */
    @TableField(exist = false)
    private BigDecimal augustPrice;

    /**
     * 九月价格
     */
    @TableField(exist = false)
    private BigDecimal septemberPrice;

    /**
     * 十月价格
     */
    @TableField(exist = false)
    private BigDecimal octoberPrice;

    /**
     * 十一月价格
     */
    @TableField(exist = false)
    private BigDecimal novemberPrice;

    /**
     * 十二月价格
     */
    @TableField(exist = false)
    private BigDecimal decemberPrice;

    /**
     * 年份
     */
    @TableField(exist = false)
    private String year;
}
