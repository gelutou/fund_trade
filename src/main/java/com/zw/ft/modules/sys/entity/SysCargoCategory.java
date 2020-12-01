package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zw.ft.common.base.BaseEntity;

/**
 * <p>
 * 货品分类表
 * </p>
 *
 * @author Savior
 * @since 2020-11-30
 */
public class SysCargoCategory extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 货品分类编号
     */
    private String categoryCode;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 上级货物分类ID
     */
    private String parentPkid;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态
     */
    @TableField("STATUS")
    private Integer status;

    private Integer flagSort;

    /**
     * 公司ID
     */
    private String comId;

    @TableField(exist = false)
    private String parentName;

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getParentPkid() {
        return parentPkid;
    }

    public void setParentPkid(String parentPkid) {
        this.parentPkid = parentPkid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFlagSort() {
        return flagSort;
    }

    public void setFlagSort(Integer flagSort) {
        this.flagSort = flagSort;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    @Override
    public String toString() {
        return "SysCargoCategory{" +
        "categoryCode=" + categoryCode +
        ", categoryName=" + categoryName +
        ", parentPkid=" + parentPkid +
        ", remark=" + remark +
        ", status=" + status +
        ", flagSort=" + flagSort +
        ", comId=" + comId +
        "}";
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
