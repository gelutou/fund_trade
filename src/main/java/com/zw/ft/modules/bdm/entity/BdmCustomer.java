package com.zw.ft.modules.bdm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 客商实体
 * </p>
 *
 * @author Oliver
 * @since 2020-12-09
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "rel_user_department")
@Data
public class BdmCustomer extends BaseEntity {

    private static final long serialVersionUID = 5093346423530256838L;
    /**
     * 公司ID
     */
    private Long comId;

    /**
     * 客商编码
     */
    private String code;

    /**
     * 客商名
     */
    private String name;

    /**
     * 客商简称
     */
    private String shortname;

    /**
     * 税务号码
     */
    private String taxNum;

    /**
     * 类型
     */
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
     * 区域
     */
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
