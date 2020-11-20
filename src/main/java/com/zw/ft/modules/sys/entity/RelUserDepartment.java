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
@TableName(value = "rel_user_department")
@Data
public class RelUserDepartment {

    private static final long serialVersionUID = 7100356565731267027L;

    /**
     *@description: 主键ID
     */
    @TableId
    private Long id;
    /**
     * 人员 人员ID
     */
    private Integer userId;

    /**
     * 部门 部门ID
     */
    private Integer deptId;

    /**
     *@description: 创建人ID
     */

    @TableField(fill = FieldFill.INSERT)
    private Long createdBy;

    /**
     *@description: 创建时间
     */

    @NotEmpty(message = "创建时间不能为空")
    private String createdTime;

    /**
     *@description: 修改人ID
     */

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updatedBy;

    /**
     *@description: 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updatedTime;
}
