package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <p>
 * 系统部门表
 * </p>
 *
 * @author Oliver
 * @since 2020-09-20
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysDepartment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     *@description: 公司ID
     */
    private long comId;
    /**
     *@description: 上级ID
     */
    private long parentId;

    /**
     *@description: 部门名称
     */
    private String deptName;

    /**
     *@description: 领导
     */
    private Integer leader;

    /**
     *@description: 下级部门
     */
    @TableField(exist = false)
    private List<SysDepartment> childs;

    @TableField(exist = false)
    private SysCompany comName;

    private Integer status;
}
