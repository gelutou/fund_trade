package com.zw.ft.modules.co.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * * <p>
 * * 加价档案表
 * * </p>
 *
 * @author savior
 * @Date 2020/11/11
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "run_rise_price")
@Data
public class RunRisePrice extends BaseEntity {

    private static final long serialVersionUID = 2920956765006675366L;
    /**
     * 公司ID
     */
    private Long cusId;

    /**
     * 调整价格
     */
    private BigDecimal riseAmount;

    /**
     * 加价状态 0 暂无加价状态 1 固定加价 2承担亏损 RISE_PRICE_STATUS
     */
    private Integer status;

}
