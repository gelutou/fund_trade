package com.zw.ft.modules.co.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * <p>
 * 销售合同表
 * </p>
 *
 * @author Oliver
 * @since 2020-12-31
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "co_contract")
@Data
public class CoContract extends BaseEntity {


    private static final long serialVersionUID = -1566825516496117594L;
    /**
     * 合同编码
     */
    @Pattern(regexp = "^^[0-9a-zA-Z]+$",message = "请传入正确的合同编码：数字和字母",groups = Add.class)
    private String code;

    /**
     * 外部编码
     */
    private String codeExpansion;

    /**
     * 合同名称
     */
    @NotNull(message = "合同名称必填",groups = Add.class)
    private String name;

    /**
     * 术语
     */
    private String terms;

    /**
     * 销售公司ID
     */
    private Long saleComId;

    /**
     * 采购公司ID
     */
    private Long buyerComId;

    /**
     * 仓储公司ID 仓储类型合同专用
     */
    private Long storageComId;

    /**
     * 联系人
     */
    private Long contactUser;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 签订日期
     */
    private String signingDate;

    /**
     * 终止日期
     */
    private String expiryDate;

    /**
     * 币种
     */
    private Integer currency;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 人员ID
     */
    private Long userId;

    /**
     * 类型 1采购合同 2销售合同 3仓储合同 CONTRACT_TYPE
     */
    private Integer type;

    /**
     * 付款类型 CONTRACT_PAYMENT_TYPE
     */
    private Integer paymentType;

    /**
     * 状态 CONTRACT_STATUS
     */
    private Integer status;

    /**
     * 合同审核状态 CONTRACT_AUDIT_STATUS
     */
    private Integer auditStatus;

    /**
     * 合同总金额
     */
    private BigDecimal totalAmount;

    /**
     * 已收款总金额
     */
    private BigDecimal receiptAmount;

    /**
     * 已付款总金额
     */
    private BigDecimal paymentAmount;

    /**
     * 退款金额
     */
    private BigDecimal refundAmount;

    /**
     * 交货时间
     */
    private String deliveryDate;

    /**
     * 协议付款日期
     */
    private String payDate;

    /**
     * 合同生效日期
     */
    private String effectiveDate;

    /**
     * 收货单位
     */
    private String receiverUnit;

    /**
     * 收货人
     */
    private String receiverName;

    /**
     * 收货人电话
     */
    private String receiverPhone;


    /**
     * 货物数量
     */
    private BigDecimal cargoQuantity;

    /**
     * 出库数量
     */
    private BigDecimal cargoQuantityOut;

    /**
     * 入库数量
     */
    private BigDecimal cargoQuantityIn;

    /**
     * 备注
     */
    private String remark;

    /**
     * 旧表ID
     */
    private String oldPkidWilldel;
}
