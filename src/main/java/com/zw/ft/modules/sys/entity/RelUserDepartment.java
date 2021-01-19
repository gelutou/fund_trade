package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * <p>
 * 人员部门关系表
 * </p>
 *
 * @author Oliver
 * @since 2020-11-03
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "rel_user_department")
@Data
public class RelUserDepartment extends BaseEntity{

    private static final long serialVersionUID = 7100356565731267027L;

    /**
     * 人员 人员ID
     */
    private Long userId;

    /**
     * 部门 部门ID
     */
    private Long deptId;

}
