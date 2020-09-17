package com.zw.ft.modules.sys.entity;

import com.zw.ft.common.base.BaseEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @ClassName SysUserExpansion
 * @Description 用户扩展信息
 * @Author Oliver
 * @Date 2020/9/14 17:45
 * @Version 1.0
 **/
public class SysUserExpansionEntity extends BaseEntity {

    private static final long serialVersionUID = -5209715190641447175L;

    /**
     *@description: 人员ID
     */
    @NotEmpty
    private long userId;
    /**
     *@description: 手机
     */
    private String mobile;
    /**
     *@description: 办公电话
     */
    private String officePhone;
    /**
     *@description: 邮件
     */
    @Email(message = "邮箱格式不正确")
    private String email;
    /**
     *@description: 生日
     */
    private Date birthday;
    /**
     *@description: 所属省份
     */
    private String province;
    /**
     *@description: 所属城市
     */
    private String city;
    /**
     *@description: 详细信息
     */
    private String address;
    /**
     *@description: 微信号
     */
    private String wechat;
    /**
     *@description: QQ号
     */
    private String qq;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Override
    public String toString() {
        return "SysUserExpansion{" +
                "userId=" + userId +
                ", mobile='" + mobile + '\'' +
                ", officePhone='" + officePhone + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", wechat='" + wechat + '\'' +
                ", qq='" + qq + '\'' +
                '}';
    }
}
