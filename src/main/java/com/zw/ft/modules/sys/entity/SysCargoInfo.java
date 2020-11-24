package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *  * <p>
 *  *  货品信息表
 *  * </p>
 * @author savior
 * @Date 2020/11/19
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_cargo_info")
@Data
public class SysCargoInfo extends BaseEntity {

    private static final long serialVersionUID = -8442917109871940228L;


    /** 货品编号 */
    private String cargoCode ;
    /** 货品名称 */
    private String cargoName ;
    /** 货品分类ID */
    private String categoryPkid ;
    /** 铝厂 */
    private String aluminumPlant ;
    /** 品牌 */
    private String brand ;
    /** 规格 */
    private String specification ;
    /** 型号 */
    private String cargoModel ;
    /** 计量单位 */
    private String cargoUnit ;
    /** 是否为库存货品 0:否  1:是 */
    private Integer flagCargoInventory ;
    /** 备注 */
    private String remark ;
    /** 状态 */
    private Integer status ;

    /** 所属公司 */
    private String comId ;

    private Integer flagSort ;



    /** 描述 */
    @TableField(exist = false)
    private String des ;

    /** 货品分类 */
    @TableField(exist = false)
    private String categoryName;

}
