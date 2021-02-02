package com.zw.ft.modules.bdm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
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
     * 货品类别ID
     */
    @NotNull(message = "请传入货品类别",groups = Add.class)
    private Long cargoCategoryId;

    /**
     * 一月价格
     */
    private BigDecimal januaryPrice;

    /**
     * 二月价格
     */
    private BigDecimal februaryPrice;

    /**
     * 三月价格
     */
    private BigDecimal marchPrice;

    /**
     * 四月价格
     */
    private BigDecimal aprilPrice;

    /**
     * 五月价格
     */
    private BigDecimal mayPrice;

    /**
     * 六月价格
     */
    private BigDecimal junePrice;

    /**
     * 七月价格
     */
    private BigDecimal julyPrice;

    /**
     * 八月价格
     */
    private BigDecimal augustPrice;

    /**
     * 九月价格
     */
    private BigDecimal septemberPrice;

    /**
     * 十月价格
     */
    private BigDecimal octoberPrice;

    /**
     * 十一月价格
     */
    private BigDecimal novemberPrice;

    /**
     * 十二月价格
     */
    private BigDecimal decemberPrice;

    /**
     * 年份
     */
    private String year;
}
