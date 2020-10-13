package com.zw.ft.modules.fund.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 内部公司表
 * </p>
 *
 * @author Oliver
 * @since 2020-10-13
 */
public class TCompany implements Serializable {

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

    private String compAddress;

    private String compCity;

    private String compCode;

    private String compDistrict;

    private String compName;

    private String compProvince;

    private Date compRegtime;

    private String compTaxNum;

    private Integer compType;

    private String contactMail;

    private String contactName;

    private String contactPhone;

    private Integer customerStates;

    private Integer flagSets;

    private String managerMail;

    private String managerMobile;

    private String managerPassword;

    private String parentId;

    private String shortCompName;

    private String systemManager;

    private String remark;

    private BigDecimal acutalCapital;

    /**
     * 地区
     */
    private String compArea;

    private String corporation;

    private String fundManager;

    private String fundMember;

    private String keepPersent;

    private Date licenseTerm;

    private String managerPhone;

    private String memberPhone;

    private String registerAddress;

    private BigDecimal registerCapital;

    private String stockHolder;

    private String taxpayerNumber;

    private Date timeLimit;

    private String workingAddress;


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

    public String getCompAddress() {
        return compAddress;
    }

    public void setCompAddress(String compAddress) {
        this.compAddress = compAddress;
    }

    public String getCompCity() {
        return compCity;
    }

    public void setCompCity(String compCity) {
        this.compCity = compCity;
    }

    public String getCompCode() {
        return compCode;
    }

    public void setCompCode(String compCode) {
        this.compCode = compCode;
    }

    public String getCompDistrict() {
        return compDistrict;
    }

    public void setCompDistrict(String compDistrict) {
        this.compDistrict = compDistrict;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompProvince() {
        return compProvince;
    }

    public void setCompProvince(String compProvince) {
        this.compProvince = compProvince;
    }

    public Date getCompRegtime() {
        return compRegtime;
    }

    public void setCompRegtime(Date compRegtime) {
        this.compRegtime = compRegtime;
    }

    public String getCompTaxNum() {
        return compTaxNum;
    }

    public void setCompTaxNum(String compTaxNum) {
        this.compTaxNum = compTaxNum;
    }

    public Integer getCompType() {
        return compType;
    }

    public void setCompType(Integer compType) {
        this.compType = compType;
    }

    public String getContactMail() {
        return contactMail;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
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

    public Integer getCustomerStates() {
        return customerStates;
    }

    public void setCustomerStates(Integer customerStates) {
        this.customerStates = customerStates;
    }

    public Integer getFlagSets() {
        return flagSets;
    }

    public void setFlagSets(Integer flagSets) {
        this.flagSets = flagSets;
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

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getShortCompName() {
        return shortCompName;
    }

    public void setShortCompName(String shortCompName) {
        this.shortCompName = shortCompName;
    }

    public String getSystemManager() {
        return systemManager;
    }

    public void setSystemManager(String systemManager) {
        this.systemManager = systemManager;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getAcutalCapital() {
        return acutalCapital;
    }

    public void setAcutalCapital(BigDecimal acutalCapital) {
        this.acutalCapital = acutalCapital;
    }

    public String getCompArea() {
        return compArea;
    }

    public void setCompArea(String compArea) {
        this.compArea = compArea;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public String getFundManager() {
        return fundManager;
    }

    public void setFundManager(String fundManager) {
        this.fundManager = fundManager;
    }

    public String getFundMember() {
        return fundMember;
    }

    public void setFundMember(String fundMember) {
        this.fundMember = fundMember;
    }

    public String getKeepPersent() {
        return keepPersent;
    }

    public void setKeepPersent(String keepPersent) {
        this.keepPersent = keepPersent;
    }

    public Date getLicenseTerm() {
        return licenseTerm;
    }

    public void setLicenseTerm(Date licenseTerm) {
        this.licenseTerm = licenseTerm;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    public BigDecimal getRegisterCapital() {
        return registerCapital;
    }

    public void setRegisterCapital(BigDecimal registerCapital) {
        this.registerCapital = registerCapital;
    }

    public String getStockHolder() {
        return stockHolder;
    }

    public void setStockHolder(String stockHolder) {
        this.stockHolder = stockHolder;
    }

    public String getTaxpayerNumber() {
        return taxpayerNumber;
    }

    public void setTaxpayerNumber(String taxpayerNumber) {
        this.taxpayerNumber = taxpayerNumber;
    }

    public Date getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Date timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getWorkingAddress() {
        return workingAddress;
    }

    public void setWorkingAddress(String workingAddress) {
        this.workingAddress = workingAddress;
    }

    @Override
    public String toString() {
        return "TCompany{" +
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
        ", compAddress=" + compAddress +
        ", compCity=" + compCity +
        ", compCode=" + compCode +
        ", compDistrict=" + compDistrict +
        ", compName=" + compName +
        ", compProvince=" + compProvince +
        ", compRegtime=" + compRegtime +
        ", compTaxNum=" + compTaxNum +
        ", compType=" + compType +
        ", contactMail=" + contactMail +
        ", contactName=" + contactName +
        ", contactPhone=" + contactPhone +
        ", customerStates=" + customerStates +
        ", flagSets=" + flagSets +
        ", managerMail=" + managerMail +
        ", managerMobile=" + managerMobile +
        ", managerPassword=" + managerPassword +
        ", parentId=" + parentId +
        ", shortCompName=" + shortCompName +
        ", systemManager=" + systemManager +
        ", remark=" + remark +
        ", acutalCapital=" + acutalCapital +
        ", compArea=" + compArea +
        ", corporation=" + corporation +
        ", fundManager=" + fundManager +
        ", fundMember=" + fundMember +
        ", keepPersent=" + keepPersent +
        ", licenseTerm=" + licenseTerm +
        ", managerPhone=" + managerPhone +
        ", memberPhone=" + memberPhone +
        ", registerAddress=" + registerAddress +
        ", registerCapital=" + registerCapital +
        ", stockHolder=" + stockHolder +
        ", taxpayerNumber=" + taxpayerNumber +
        ", timeLimit=" + timeLimit +
        ", workingAddress=" + workingAddress +
        "}";
    }
}
