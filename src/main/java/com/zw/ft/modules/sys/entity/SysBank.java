package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  * <p>
 *  * 银行信息表
 *  * </p>
 * @author savior
 * @Date 2020/9/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysBank extends BaseEntity {

    /** 公司id */
    private Integer comId ;

    /** 客商ID */
    //private Integer customerId ;

    /** 开户行名称 */
    private String bankName ;

    /** 银行简称 */
    private String shortName;

    /** 账号 */
    private String bankAccount;

    /** 账户类别 */
    private String accountStyle;

    /** 账户性质 */
    private String accountType;

    /** 账户余额 */
    private Double accountBalance ;

    /** 银行地区分类 */
    private String areaType ;

    /** 备注 */
    private String remark;

    /** 公司名称 */
    @TableField(exist = false)
    private String comName;
}
