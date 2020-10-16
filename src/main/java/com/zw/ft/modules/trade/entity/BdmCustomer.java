package com.zw.ft.modules.trade.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 客商表
 * </p>
 *
 * @author Oliver
 * @since 2020-10-15
 */
@TableName(value = "bdm_customer")
@Data
public class BdmCustomer {

    private static final long serialVersionUID = 1L;

    private String pkId;

    private String companyPkid;

    private String customerCode;

    private String customerName;

    private String customerShortName;

    private String customerType;

    private String customerPhone;

    private String customerMail;

    private String customerFax;

    private String cityVirtual;

    private String taxNumber;

    private String makeUser;

    private Date makeTime;

    private String modifyUser;

    private Date modifyTime;

    private Integer flagStatus;

    private Integer flagSort;

    /**
     * 0 有效 1 已删除
     */
    private Integer flagDelete;

    private Long flagVersion;

    private String compPkid;

    private Integer flagAudit;

    private String auditPid;

}
