package com.zw.ft.modules.bdm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 客商实体
 * </p>
 *
 * @author Oliver
 * @since 2020-12-09
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "bdm_customer")
@Data
public class BdmCustomer extends BaseEntity {

    private static final long serialVersionUID = 5093346423530256838L;
    /**
     * 公司ID
     */
    @NotNull
    private Long comId;

    /**
     * 客商编码
     */
    @NotNull
    private String code;

    /**
     * 客商名
     */
    @NotNull
    private String name;

    /**
     * 客商简称
     */
    @NotNull
    private String shortname;

    /**
     * 税务号码
     */
    private String taxNum;

    /**
     * 类型
     */
    @NotNull
    private Integer type;

    /**
     * 类型描述
     */
    @TableField(exist = false)
    private String typeDes;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 联系邮箱
     */
    private String contactEmail;

    /**
     * 联系人职位
     */
    private String contactPosition;

    /**
     * 客商地址
     */
    @NotNull
    private String area;

    /**
     * @description: 数据来源 0资金 1商贸
     */
    private Integer fundOrTrade;

    /**
     * 旧的部门PKID，只用于合并数据，系统上线后删除
     */
    private String oldPkidWilldel;

    /**
     * 创建人名称
     */
    @TableField(exist = false)
    private String creator;
}
