package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * * <p>
 * *  货品信息表
 * * </p>
 *
 * @author savior
 * @Date 2020/11/19
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_cargo_info")
@Data
public class SysCargoInfo extends BaseEntity {

    private static final long serialVersionUID = -8442917109871940228L;

    /**
     * 货品编号
     */
    @Pattern(regexp = "^^[0-9a-zA-Z]+$",message = "请传入正确的货品编号：数字和字母",groups = Add.class)
    private String cargoCode;
    /**
     * 货品名称
     */
    @NotNull(message = "请传入货品名称",groups = Add.class)
    private String cargoName;
    /**
     * 货品分类ID
     */
    //@Pattern(regexp = "/^\\d+$|^\\d+[.]?\\d+$/",message = "只能输入数字 请传入货品分类ID",groups = Add.class)
    private String categoryPkid;
    /**
     * 铝厂
     */
    private String aluminumPlant;
    /**
     * 品牌
     */
    private String brand;
    /**
     * 规格
     */
    private String specification;
    /**
     * 型号
     */
    private String cargoModel;
    /**
     * 计量单位
     */

    private String cargoUnit;

    /**
     * 是否为库存货品 0:否  1:是
     */
    @NotNull(message = "请传入是否为库存货品 0:否  1:是",groups = Add.class)
    private Integer flagCargoInventory;
    /**
     * 备注
     */
    private String remark;
    /**
     * 状态
     */
    private Integer status;

    /**
     * 所属公司
     */
    private String comId;

    private Integer flagSort;


    /**
     * 描述
     */
    @TableField(exist = false)
    private String des;

    /**
     * 货品分类
     */
    @TableField(exist = false)
    private String categoryName;

}
