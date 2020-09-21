package com.zw.ft.modules.sys.entity;

import com.zw.ft.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 员工公司信息表 
 * </p>
 *
 * @author Oliver
 * @since 2020-09-21
 */
@ApiModel(value="SysUserCompany对象", description="员工公司信息表 ")
public class SysUserCompany extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公司")
    private Integer comId;

    @ApiModelProperty(value = "员工")
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
