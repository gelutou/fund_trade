package com.zw.ft.modules.trade.entity;

import com.zw.ft.common.base.BaseEntity;
import java.util.Date;

/**
 * <p>
 * 组织机构表
 * </p>
 *
 * @author Oliver
 * @since 2020-10-14
 */
public class SysOrgan extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String pkId;

    private String organCode;

    private String organName;

    private String parentPkid;

    private String parentPath;

    private String manager;

    private String remark;

    private Integer flagStatus;

    private Integer flagSort;

    private Integer flagDelete;

    private Long flagVersion;

    private String makeUser;

    private Date makeTime;

    private String modifyUser;

    private Date modifyTime;

    private String compPkid;

    private Integer flagAudit;

    private String auditPid;


    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getParentPkid() {
        return parentPkid;
    }

    public void setParentPkid(String parentPkid) {
        this.parentPkid = parentPkid;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getFlagStatus() {
        return flagStatus;
    }

    public void setFlagStatus(Integer flagStatus) {
        this.flagStatus = flagStatus;
    }

    public Integer getFlagSort() {
        return flagSort;
    }

    public void setFlagSort(Integer flagSort) {
        this.flagSort = flagSort;
    }

    public Integer getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(Integer flagDelete) {
        this.flagDelete = flagDelete;
    }

    public Long getFlagVersion() {
        return flagVersion;
    }

    public void setFlagVersion(Long flagVersion) {
        this.flagVersion = flagVersion;
    }

    public String getMakeUser() {
        return makeUser;
    }

    public void setMakeUser(String makeUser) {
        this.makeUser = makeUser;
    }

    public Date getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(Date makeTime) {
        this.makeTime = makeTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCompPkid() {
        return compPkid;
    }

    public void setCompPkid(String compPkid) {
        this.compPkid = compPkid;
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

    @Override
    public String toString() {
        return "SysOrgan{" +
        "pkId=" + pkId +
        ", organCode=" + organCode +
        ", organName=" + organName +
        ", parentPkid=" + parentPkid +
        ", parentPath=" + parentPath +
        ", manager=" + manager +
        ", remark=" + remark +
        ", flagStatus=" + flagStatus +
        ", flagSort=" + flagSort +
        ", flagDelete=" + flagDelete +
        ", flagVersion=" + flagVersion +
        ", makeUser=" + makeUser +
        ", makeTime=" + makeTime +
        ", modifyUser=" + modifyUser +
        ", modifyTime=" + modifyTime +
        ", compPkid=" + compPkid +
        ", flagAudit=" + flagAudit +
        ", auditPid=" + auditPid +
        "}";
    }
}
