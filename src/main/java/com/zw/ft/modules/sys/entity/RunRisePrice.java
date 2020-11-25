package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * * <p>
 * * 加价档案表
 * * </p>
 *
 * @author savior
 * @Date 2020/11/11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RunRisePrice extends BaseEntity {

    private static final long serialVersionUID = 2920956765006675366L;
    /**
     * 公司ID
     */
    private String comId;

    /**
     * 调整价格
     */
    private Double risePrice;

    /**
     * 1：固定加价0：暂无固定加价-1：承担亏损
     */
    private String fixed;

    /**
     * 备注
     */
    private String remark;

    /**
     * 公司名称
     */
    @TableField(exist = false)
    private String comName;

    /**
     * 所属城市
     */
    @TableField(exist = false)
    private String city;

    /**
     * 描述
     */
    @TableField(exist = false)
    private String des;

}
