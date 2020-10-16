package com.zw.ft.modules.fund.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 客商表
 * </p>
 *
 * @author Oliver
 * @since 2020-10-15
 */
@TableName(value = "t_customer")
public class TCustomer implements Serializable {

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

    private String areaType;

    private String contactPerson;

    private String contactPhone;

    private String customerCode;

    private String customerMail;

    private String customerName;

    /**
     * 1内部2客商3仓储4集团
     */
    private String customerType;

    private String remark;

    private String companyPkid;

    private String customerShortName;

    private BigDecimal acutalCapital;

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

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCompanyPkid() {
        return companyPkid;
    }

    public void setCompanyPkid(String companyPkid) {
        this.companyPkid = companyPkid;
    }

    public String getCustomerShortName() {
        return customerShortName;
    }

    public void setCustomerShortName(String customerShortName) {
        this.customerShortName = customerShortName;
    }

    public BigDecimal getAcutalCapital() {
        return acutalCapital;
    }

    public void setAcutalCapital(BigDecimal acutalCapital) {
        this.acutalCapital = acutalCapital;
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
        return "TCustomer{" +
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
        ", areaType=" + areaType +
        ", contactPerson=" + contactPerson +
        ", contactPhone=" + contactPhone +
        ", customerCode=" + customerCode +
        ", customerMail=" + customerMail +
        ", customerName=" + customerName +
        ", customerType=" + customerType +
        ", remark=" + remark +
        ", companyPkid=" + companyPkid +
        ", customerShortName=" + customerShortName +
        ", acutalCapital=" + acutalCapital +
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
