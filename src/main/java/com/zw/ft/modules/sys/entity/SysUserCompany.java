package com.zw.ft.modules.sys.entity;

import com.zw.ft.common.base.BaseEntity;

/**
 * <p>
 * 员工公司信息表 
 * </p>
 *
 * @author Oliver
 * @since 2020-09-21
 */
public class SysUserCompany extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Integer comId;

    private Integer userId;


    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "SysUserCompany{" +
        "comId=" + comId +
        ", userId=" + userId +
        "}";
    }
}
