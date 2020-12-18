package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * <p>
 * 公司信息表
 * </p>
 *
 * @author Oliver
 * @since 2020-09-21
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_company")
@Data
public class SysCompany extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 公司代码
     */
    @NotNull(message = "公司代码必填",groups = Add.class)
    @Pattern(regexp = "^[0-9a-zA-Z]+$",message = "只能输入英文和数字",groups = Update.class)
    private String comCode;

    /**
     * @description: 公司名称
     */
    @NotNull(message = "公司名称必填",groups = Add.class)
    private String comName;

    /**
     * @description: 公司简称
     */
    @NotNull(message = "公司名称必填",groups = Add.class)
    private String shortComName;

    /**
     * @description: 联系人
     */
    private String contactUser;

    /**
     * @description: 所属省份
     */
    private String province;

    /**
     * @description: 所属城市
     */
    private String city;

    /**
     * @description: 所属区域
     */
    private String district;

    /**
     * @description: 详细地址
     */
    private String address;

    /**
     * @description: 父公司
     */
    private Integer parentId;

    /**
     * @description: 公司联系电话
     */
    @NotNull(message = "公司电话必填",groups = Add.class)
    private String mobile;

    /**
     * @description: 公司类型 1内部 2 外部 3 仓储 4集团
     */
    @NotNull(message = "公司类型必填",groups = Add.class)
    private Integer status;

    /**
     * @description: 数据来源 0资金 1商贸
     */
    private Integer fundOrTrade;

    private String taxNumber;

    /**
     * @description: 旧公司ID，上线后删除
     */
    private String oldPkidWilldel;

}
