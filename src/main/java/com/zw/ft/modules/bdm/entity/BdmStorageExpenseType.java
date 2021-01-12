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
 * 仓储费用类型表
 * </p>
 *
 * @author Savior
 * @since 2020-12-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "bdm_storage_expense_type")
public class BdmStorageExpenseType extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 父级分类ID
     */
    @NotNull(message = "请传入上级仓储ID",groups = Add.class)
    private Integer parentId;

    //父级分类ID名字
    @TableField(exist = false)
    private String pName;

    /**
     * 仓储分类编号
     */
    @Pattern(regexp = "^^[0-9a-zA-Z]+$",message = "请传入正确的仓储分类编号：数字和字母",groups =Add.class)
    @Pattern(regexp = "^^[0-9a-zA-Z]+$",message = "请传入正确的仓储分类编号：数字和字母",groups =Update.class)
    private String code;

    /**
     * 仓储分类名称
     */
    @NotNull(message = "请传入仓储分类名称",groups = Add.class)
    private String name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 公司ID
     */
    private String comId;


}
