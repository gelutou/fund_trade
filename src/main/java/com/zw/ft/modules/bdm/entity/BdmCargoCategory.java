package com.zw.ft.modules.bdm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * <p>
 * 货品分类表
 * </p>
 *
 * @author Savior
 * @since 2020-11-30
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "bdm_cargo_category")
@Data
public class BdmCargoCategory extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 货品分类编号
     */
    @Pattern(regexp = "^^[0-9a-zA-Z]+$",message = "请传入正确的货品分类编号：数字和字母",groups = Add.class)
    private String categoryCode;

    /**
     * 分类名称
     */
    @NotNull(message = "请传入分类名称",groups = Add.class)
    private String categoryName;

    /**
     * 上级货物分类ID
     */
    @NotNull(message = "请传入上级货物分类ID",groups = Add.class)
    private Long parentPkid;

    /**
     * 备注
     */
    private String remark;

    /**
     * 货品分类状态
     */
    private Integer status;

    //父级分类名称
    @TableField(exist = false)
    private String parentName;

}
