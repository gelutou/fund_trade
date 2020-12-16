package com.zw.ft.modules.bdm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 仓库信息表
 * </p>
 *
 * @author Savior
 * @since 2020-12-14
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "bdm_warehouse")
@Data
public class BdmWarehouse extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 上级仓库ID
     */
    @TableField("PARENT_PKID")
    private String parentPkid;

    /**
     * 仓库编号
     */
    @TableField("WAREHOUSE_CODE")
    private String warehouseCode;

    /**
     * 仓储公司ID
     */
    @TableField("CUSTOMER_PKID")
    private String customerPkid;

    /**
     * 仓库名称
     */
    @TableField("WAREHOUSE_NAME")
    private String warehouseName;

    /**
     * 仓库管理员
     */
    @TableField("WAREHOUSE_MANAGER")
    private String warehouseManager;

    /**
     * 仓库联系电话
     */
    @TableField("WAREHOUSE_PHONE")
    private String warehousePhone;

    /**
     * 虚拟仓库位
     */
    @TableField("FLAG_VIRTUAL")
    private String flagVirtual;

    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;

    /**
     * 状态
     */
    @TableField("STATUS")
    private String status;

    /**
     * 公司ID
     */
    private String comId;

    @TableField("FLAG_AUDIT")
    private Integer flagAudit;

    /**
     * 流程实例ID
     */
    @TableField("AUDIT_PID")
    private String auditPid;

    /**
     * 省
     */
    @TableField("PROVINCE")
    private String province;

    /**
     * 城市
     */
    @TableField("CITY")
    private String city;

    /**
     * 地区
     */
    @TableField("DISTRICT")
    private String district;

    /**
     * 详细地址
     */
    @TableField("DETAIL_ADDRESS")
    private String detailAddress;

    /**
     * QQ号
     */
    @TableField("QQ")
    private String qq;

    /**
     * 邮箱
     */
    @TableField("EMAIL")
    private String email;

    /**
     * 微信
     */
    @TableField("WeChat")
    private String WeChat;

    /**
     * 逻辑删除 0正常1删除
     */
    @TableField("DELETED")
    private Integer deleted;

    /**
     * 父级仓库名称
     */
    @TableField(exist = false)
    private String parentName;

    /**
     */
    @TableField(exist = false)
    private String customerName;
}
