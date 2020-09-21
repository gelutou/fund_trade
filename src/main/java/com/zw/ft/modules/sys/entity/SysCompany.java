package com.zw.ft.modules.sys.entity;

import com.zw.ft.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 公司信息表
 * </p>
 *
 * @author Oliver
 * @since 2020-09-21
 */
@ApiModel(value="SysCompany对象", description="公司信息表")
public class SysCompany extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公司编码")
    private String comCode;

    @ApiModelProperty(value = "公司名称")
    private String comName;

    @ApiModelProperty(value = "公司简称")
    private String shortComName;

    @ApiModelProperty(value = "公司联系人")
    private Integer contactUser;

    @ApiModelProperty(value = "公司所属省份")
    private String province;

    @ApiModelProperty(value = "公司所属城市")
    private String city;

    @ApiModelProperty(value = "公司所属区域")
    private String district;

    @ApiModelProperty(value = "公司详细地址")
    private String address;

    @ApiModelProperty(value = "父公司所属")
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
