package com.zw.ft.modules.sys.entity;

import com.zw.ft.common.base.BaseEntity;
/**
 * <p>
 * 公司信息表
 * </p>
 *
 * @author Oliver
 * @since 2020-09-21
 */
public class SysCompany extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String comCode;

    private String comName;

    private String shortComName;

    private Integer contactUser;

    private String province;

    private String city;

    private String district;

    private String address;

    private Integer parentId;


    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getShortComName() {
        return shortComName;
    }

    public void setShortComName(String shortComName) {
        this.shortComName = shortComName;
    }

    public Integer getContactUser() {
        return contactUser;
    }

    public void setContactUser(Integer contactUser) {
        this.contactUser = contactUser;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "SysCompany{" +
        "comCode=" + comCode +
        ", comName=" + comName +
        ", shortComName=" + shortComName +
        ", contactUser=" + contactUser +
        ", province=" + province +
        ", city=" + city +
        ", district=" + district +
        ", address=" + address +
        ", parentId=" + parentId +
        "}";
    }
}
