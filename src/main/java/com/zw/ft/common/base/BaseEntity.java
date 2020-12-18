package com.zw.ft.common.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @ClassName BaseEntity
 * @Description 基础实体
 * @Author Oliver
 * @Date 2020/9/9 16:38
 * @Version 1.0
 **/
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -8496506980578081121L;

    /**
     * 添加校验组
     */
    public interface Add {}

    /**
     * 更新校验组
     */
    public interface Update {}

    /**
     * @description: 主键ID
     */
    @TableId
    @Pattern(regexp = "/^\\d+$|^\\d+[.]?\\d+$/",message = "只能输入数字",groups = Update.class)
    @Null(message = "ID值必须为空",groups = Add.class)
    private Long id;

    /**
     * @description: 创建人ID
     */

    @TableField(fill = FieldFill.INSERT)
    private Long createdBy;

    /**
     * @description: 创建时间
     */

    @TableField(fill = FieldFill.INSERT)
    private String createdTime;

    /**
     * @description: 修改人ID
     */

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updatedBy;

    /**
     * @description: 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updatedTime;

    /**
     * @description: 逻辑删除
     */
    @TableLogic
    private Integer deleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseEntity that = (BaseEntity) o;
        return id.equals(that.id) &&
                // status.equals(that.status) &&
                createdBy.equals(that.createdBy) &&
                createdTime.equals(that.createdTime) &&
                updatedBy.equals(that.updatedBy) &&
                deleted.equals(that.deleted) &&
                updatedTime.equals(that.updatedTime);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
        result = prime * result + ((createdTime == null) ? 0 : createdTime.hashCode());
        result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
        result = prime * result + ((updatedTime == null) ? 0 : updatedTime.hashCode());
        result = prime * result + ((deleted == null) ? 0 : deleted.hashCode());
        return result;
    }

}
