package com.zw.ft.modules.bdm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
    @NotNull(message = "请传入上级仓库ID",groups = Add.class)
    @TableField("PARENT_PKID")
    private String parentPkid;

    /**
     * 仓库编号
     */
    @Pattern(regexp = "^^[0-9a-zA-Z]+$",message = "请传入正确的仓库编号：数字和字母",groups = Add.class)
    @TableField("WAREHOUSE_CODE")
    private String warehouseCode;

    /**
     * 仓储公司ID
     */
    @NotNull(message = "请传入仓储公司ID",groups = Add.class)
    @TableField("CUSTOMER_PKID")
    private String customerPkid;

    /**
     * 仓库名称
     */
    @NotNull(message = "请传入仓库名称",groups = Add.class)
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
     * 客商ID
     */
    @Pattern(regexp = "/^\\d+$|^\\d+[.]?\\d+$/",message = "只能输入数字",groups = Add.class)
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
     * 父级仓库名称
     */
    @TableField(exist = false)
    private String parentName;

    /**
     * 客商仓储公司名称
     */
    @TableField(exist = false)
    private String customerName;
}
