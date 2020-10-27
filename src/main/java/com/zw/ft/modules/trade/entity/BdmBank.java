package com.zw.ft.modules.trade.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 银行表
 * </p>
 *
 * @author Savior
 * @since 2020-10-20
 */
@TableName(value = "bdm_bank")
@Data
public class BdmBank implements Serializable {

    private static final long serialVersionUID = 1L;

    private String pkId;

    /**
     * 客商ID
     */
    private String customerPkid;

    /**
     * 默认选择
     */
    private String flagDefault;

    /**
     * 账号
     */
    private String bankAccount;

    /**
     * 开户行名称
     */
    private String bankName;

    /**
     * 备注
     */
    private String remark;

    private String makeUser;

    private Date makeTime;

    private String modifyUser;

    private Date modifyTime;

    private Integer flagStatus;

    private Integer flagSort;

    private String compPkid;

    /**
     * 0 有效 1 已删除
     */
    private Integer flagDelete;

    private Long flagVersion;

    private Integer flagAudit;

    private String auditPid;


}
