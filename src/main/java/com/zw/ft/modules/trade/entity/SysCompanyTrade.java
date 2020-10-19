package com.zw.ft.modules.trade.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * <p>
 * 公司信息表	与客商使用相同的表
 * </p>
 *
 * @author Oliver
 * @since 2020-10-13
 */
@TableName(value = "sys_company")
@Data
public class SysCompanyTrade {

    private static final long serialVersionUID = 1L;

    private String pkId;

    private String compCode;

    private String compName;

    private String shortCompName;

    private String contactName;

    private String contactPhone;

    private String contactMail;

    @TableField("comp_taxNum")
    private String compTaxnum;

    private Date compRegtime;

    private String compProvince;

    private String compCity;

    private String compDistrict;

    private String compAddress;

    private Integer flagStatus;

    private String systemManager;

    private String managerPassword;

    private String managerMail;

    private String managerMobile;

    private String parentPkid;

    private Integer compType;

    private Integer customerStates;

    private Integer flagSort;

    private Integer flagDelete;

    private Long flagVersion;

    private Integer flagSets;

    private String makeUser;

    private Date makeTime;

    private String modifyUser;

    private Date modifyTime;

    private String compPkid;

    private Integer flagAudit;

    private String auditPid;

    private String qq;

    private String weixin;


    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public String getCompCode() {
        return compCode;
    }

    public void setCompCode(String compCode) {
        this.compCode = compCode;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getShortCompName() {
        return shortCompName;
    }

    public void setShortCompName(String shortCompName) {
        this.shortCompName = shortCompName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactMail() {
        return contactMail;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    public String getCompTaxnum() {
        return compTaxnum;
    }

    public void setCompTaxnum(String compTaxnum) {
        this.compTaxnum = compTaxnum;
    }

    public Date getCompRegtime() {
        return compRegtime;
    }

    public void setCompRegtime(Date compRegtime) {
        this.compRegtime = compRegtime;
    }

    public String getCompProvince() {
        return compProvince;
    }

    public void setCompProvince(String compProvince) {
        this.compProvince = compProvince;
    }

    public String getCompCity() {
        return compCity;
    }

    public void setCompCity(String compCity) {
        this.compCity = compCity;
    }

    public String getCompDistrict() {
        return compDistrict;
    }

    public void setCompDistrict(String compDistrict) {
        this.compDistrict = compDistrict;
    }

    public String getCompAddress() {
        return compAddress;
    }

    public void setCompAddress(String compAddress) {
        this.compAddress = compAddress;
    }

    public Integer getFlagStatus() {
        return flagStatus;
    }

    public void setFlagStatus(Integer flagStatus) {
        this.flagStatus = flagStatus;
    }

    public String getSystemManager() {
        return systemManager;
    }

    public void setSystemManager(String systemManager) {
        this.systemManager = systemManager;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getManagerMail() {
        return managerMail;
    }

    public void setManagerMail(String managerMail) {
        this.managerMail = managerMail;
    }

    public String getManagerMobile() {
        return managerMobile;
    }

    public void setManagerMobile(String managerMobile) {
        this.managerMobile = managerMobile;
    }

    public String getParentPkid() {
        return parentPkid;
    }

    public void setParentPkid(String parentPkid) {
        this.parentPkid = parentPkid;
    }

    public Integer getCompType() {
        return compType;
    }

    public void setCompType(Integer compType) {
        this.compType = compType;
    }

    public Integer getCustomerStates() {
        return customerStates;
    }

    public void setCustomerStates(Integer customerStates) {
        this.customerStates = customerStates;
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

    public Integer getFlagSets() {
        return flagSets;
    }

    public void setFlagSets(Integer flagSets) {
        this.flagSets = flagSets;
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

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    @Override
    public String toString() {
        return "SysCompany{" +
        "pkId=" + pkId +
        ", compCode=" + compCode +
        ", compName=" + compName +
        ", shortCompName=" + shortCompName +
        ", contactName=" + contactName +
        ", contactPhone=" + contactPhone +
        ", contactMail=" + contactMail +
        ", compTaxnum=" + compTaxnum +
        ", compRegtime=" + compRegtime +
        ", compProvince=" + compProvince +
        ", compCity=" + compCity +
        ", compDistrict=" + compDistrict +
        ", compAddress=" + compAddress +
        ", flagStatus=" + flagStatus +
        ", systemManager=" + systemManager +
        ", managerPassword=" + managerPassword +
        ", managerMail=" + managerMail +
        ", managerMobile=" + managerMobile +
        ", parentPkid=" + parentPkid +
        ", compType=" + compType +
        ", customerStates=" + customerStates +
        ", flagSort=" + flagSort +
        ", flagDelete=" + flagDelete +
        ", flagVersion=" + flagVersion +
        ", flagSets=" + flagSets +
        ", makeUser=" + makeUser +
        ", makeTime=" + makeTime +
        ", modifyUser=" + modifyUser +
        ", modifyTime=" + modifyTime +
        ", compPkid=" + compPkid +
        ", flagAudit=" + flagAudit +
        ", auditPid=" + auditPid +
        ", qq=" + qq +
        ", weixin=" + weixin +
        "}";
    }
}
