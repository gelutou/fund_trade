package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
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


    private static final long serialVersionUID = 7435587701733126501L;
    /**
     * @description: 公司名称首字母缩略词
     */
    @NotNull(message = "公司名称首字母缩略词必填",groups = Add.class)
    @Pattern(regexp = "^[0-9a-zA-Z]+$",message = "只能输入英文和数字",groups = Update.class)
    private String acronym;

    /**
     * @description: 公司名称
     */
    @NotNull(message = "公司名称必填",groups = Add.class)
    private String name;

    /**
     * @description: 公司简称
     */
    @NotNull(message = "公司简称必填",groups = Add.class)
    private String shortName;

    /**
     * @description: 联系人
     */
    @NotNull(message = "公司联系人必填",groups = Add.class)
    private String contactUser;

    /**
     * @description: 所属省份
     */
    private Long province;

    /**
     * @description: 所属省份名称
     */
    @TableField(exist = false)
    private String provinceName;

    /**
     * @description: 所属城市
     */
    private Long city;

    /**
     * @description: 所属城市名称
     */
    @TableField(exist = false)
    private String cityName;

    /**
     * @description: 所属区县
     */
    private Long district;
    /**
     * @description: 所属区县名称
     */
    @TableField(exist = false)
    private String districtName;

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
     * @description: 税号
     */
    private String taxNumber;

    /**
     * @description: 数据来源 0资金 1商贸
     */
    private Integer fundOrTrade;

    /**
     * @description: 旧公司ID，上线后删除
     */
    private String oldPkidWilldel;

}
