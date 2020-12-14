package com.zw.ft.modules.bdm.entity;

import com.zw.ft.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * <p>
 * 仓库信息表
 * </p>
 *
 * @author Savior
 * @since 2020-12-14
 */
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


    public String getParentPkid() {
        return parentPkid;
    }

    public void setParentPkid(String parentPkid) {
        this.parentPkid = parentPkid;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getCustomerPkid() {
        return customerPkid;
    }

    public void setCustomerPkid(String customerPkid) {
        this.customerPkid = customerPkid;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseManager() {
        return warehouseManager;
    }

    public void setWarehouseManager(String warehouseManager) {
        this.warehouseManager = warehouseManager;
    }

    public String getWarehousePhone() {
        return warehousePhone;
    }

    public void setWarehousePhone(String warehousePhone) {
        this.warehousePhone = warehousePhone;
    }

    public String getFlagVirtual() {
        return flagVirtual;
    }

    public void setFlagVirtual(String flagVirtual) {
        this.flagVirtual = flagVirtual;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public Integer getFlagAudit() {
        return flagAudit;
    }

    public void setFlagAudit(Integer flagAudit) {
        this.flagAudit = flagAudit;
    }

    public String getAuditPid() {
        return auditPid;
    }

    public void setAuditPid(String auditPid) {
        this.auditPid = auditPid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeChat() {
        return WeChat;
    }

    public void setWeChat(String WeChat) {
        this.WeChat = WeChat;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "BdmWarehouse{" +
        "parentPkid=" + parentPkid +
        ", warehouseCode=" + warehouseCode +
        ", customerPkid=" + customerPkid +
        ", warehouseName=" + warehouseName +
        ", warehouseManager=" + warehouseManager +
        ", warehousePhone=" + warehousePhone +
        ", flagVirtual=" + flagVirtual +
        ", remark=" + remark +
        ", status=" + status +
        ", comId=" + comId +
        ", flagAudit=" + flagAudit +
        ", auditPid=" + auditPid +
        ", province=" + province +
        ", city=" + city +
        ", district=" + district +
        ", detailAddress=" + detailAddress +
        ", qq=" + qq +
        ", email=" + email +
        ", WeChat=" + WeChat +
        ", deleted=" + deleted +
        "}";
    }
}
