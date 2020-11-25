package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统部门表
 * </p>
 *
 * @author Oliver
 * @since 2020-10-16
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_department")
@Data
public class SysDepartment extends BaseEntity {

    private static final long serialVersionUID = -888106179543546494L;
    /**
     * 所属公司
     */
    private Long comId;

    /**
     * 父级ID
     */
    private Long parentId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * @description: 表示此部门是几级部门 1 = 一级部门
     */
    private Integer deptLevel;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 部门负责人
     */
    private String leader;

    /**
     * 旧的部门PKID，只用于合并数据，系统上线后删除
     */
    private String oldPkidWilldel;

    @TableField(exist = false)
    private SysCompany comName;

}
