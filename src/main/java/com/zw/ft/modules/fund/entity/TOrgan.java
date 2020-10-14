package com.zw.ft.modules.fund.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 部门档案表
 * </p>
 *
 * @author Oliver
 * @since 2020-10-14
 */
public class TOrgan implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String compId;

    private Integer flagDelete;

    private Integer flagSort;

    private Integer flagStatus;

    private Integer flagVersion;

    private Date makeTime;

    private String makeUser;

    private Date modifyTime;

    private String modifyUser;

    private String organCode;

    private String organName;

    private String parentPath;

    private String remark;

    private String parentId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public Integer getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(Integer flagDelete) {
        this.flagDelete = flagDelete;
    }

    public Integer getFlagSort() {
        return flagSort;
    }

    public void setFlagSort(Integer flagSort) {
        this.flagSort = flagSort;
    }

    public Integer getFlagStatus() {
        return flagStatus;
    }

    public void setFlagStatus(Integer flagStatus) {
        this.flagStatus = flagStatus;
    }

    public Integer getFlagVersion() {
        return flagVersion;
    }

    public void setFlagVersion(Integer flagVersion) {
        this.flagVersion = flagVersion;
    }

    public Date getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(Date makeTime) {
        this.makeTime = makeTime;
    }

    public String getMakeUser() {
        return makeUser;
    }

    public void setMakeUser(String makeUser) {
        this.makeUser = makeUser;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
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

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "TOrgan{" +
        "id=" + id +
        ", compId=" + compId +
        ", flagDelete=" + flagDelete +
        ", flagSort=" + flagSort +
        ", flagStatus=" + flagStatus +
        ", flagVersion=" + flagVersion +
        ", makeTime=" + makeTime +
        ", makeUser=" + makeUser +
        ", modifyTime=" + modifyTime +
        ", modifyUser=" + modifyUser +
        ", organCode=" + organCode +
        ", organName=" + organName +
        ", parentPath=" + parentPath +
        ", remark=" + remark +
        ", parentId=" + parentId +
        "}";
    }
}
