package com.zw.ft.modules.co.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 合同货物表
 * </p>
 *
 * @author Oliver
 * @since 2021-01-18
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "co_contract_items")
@Data
public class CoContractItems extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 合同ID
     */
    private Long contractId;

    /**
     * 货品ID
     */
    private Long cargoId;

    /**
     * 客商ID
     */
    private Long cusId;

    /**
     * 货品数量
     */
    private BigDecimal cargoQuantity;

    /**
     * 货品最大数量
     */
    private BigDecimal cargoMaxQuantity;

    /**
     * 货品最小数量
     */
    private BigDecimal cargoMinQuantity;

    /**
     * 浮动范围
     */
    private BigDecimal floatRange;

    /**
     * 含税单价
     */
    private BigDecimal unitPrice;

    /**
     * 含税总金额
     */
    private String totalAmountTaxIncluded;

    /**
     * 不含税总金额
     */
    private String totalAmountTaxNotIncluded;

    /**
     * 货品出库数量
     */
    private String quantityOutStorage;

    /**
     * 货品入库数量
     */
    private String quantityInStorage;

    /**
     * 已付款数量
     */
    private String quantityAccountPaid;

    /**
     * 已收款数量
     */
    private String quantityAccountReceived;
}
