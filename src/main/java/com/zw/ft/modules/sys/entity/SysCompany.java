package com.zw.ft.modules.sys.entity;

import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 公司信息表
 * </p>
 *
 * @author Oliver
 * @since 2020-09-21
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysCompany extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     *@description: 公司代码
     */
    private String comCode;

    /**
     *@description: 公司名称
     */
    private String comName;

    /**
     *@description: 公司简称
     */
    private String shortComName;

    /**
     *@description: 联系人
     */
    private Integer contactUser;

    /**
     *@description: 所属省份
     */
    private String province;

    /**
     *@description: 所属城市
     */
    private String city;

    /**
     *@description: 所属区域
     */
    private String district;

    /**
     *@description: 详细地址
     */
    private String address;

    /**
     *@description: 父部门
     */
    private Integer parentId;
}
