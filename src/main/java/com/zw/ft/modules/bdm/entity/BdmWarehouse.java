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
 * 仓库信息表
 * </p>
 *
 * @author Savior
 * @since 2020-12-14
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "bdm_warehouse")
@Data
public class BdmWarehouse extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 上级仓库ID
     */
    @NotNull(message = "请传入上级仓库ID",groups = Add.class)
    private Integer parentId;

    /**
     * 父级仓库名称
     *
     */
    @TableField(exist = false)
    private String parentName;


    /**
     * 仓库编号
     */
    @Pattern(regexp = "^^[0-9a-zA-Z]+$",message = "请传入正确的仓库编号：数字和字母",groups = Add.class)
    private String code;

    /**
     * 客商ID
     */
    @NotNull(message = "ID不能为空并且只能为数字",groups = Add.class)
    private Long cusId;

    /**
     * 客商仓储公司名称
     */
    @TableField(exist = false)
    private String customerName;

    /**
     * 仓库名称
     */
    @NotNull(message = "请传入仓库名称",groups = Add.class)
    private String name;

    /**
     * 仓库负责人
     */
    @NotNull(message = "请传入仓库负责人",groups = Add.class)
    private String personCharge;

    /**
     * 仓库联系电话
     */
    @NotNull(message = "请传入仓库联系电话",groups = Add.class)
    private String phone;

    /**
     * 虚拟仓库位  0:非虚拟仓库  1：虚拟仓库
     */
    @NotNull(message = "请传入虚拟仓库位,0:非虚拟仓库 1：虚拟仓库",groups = Add.class)
    private Integer isVirtual;
    @TableField(exist = false)
    private String isVirtualName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 详细地址
     */
    private String detailAddress;

}
