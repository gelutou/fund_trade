package com.zw.ft.common.base;

import com.baomidou.mybatisplus.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName BaseEntity
 * @Description 基础实体
 * @Author Oliver
 * @Date 2020/9/9 16:38
 * @Version 1.0
 **/
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -8496506980578081121L;

    /**
     *@description: 主键ID
     */
    @TableId
    @NotEmpty(message = "主键不能为空")
    private Long id;

    /**
     *@description: 乐观锁
     */
    @Version
    @NotEmpty(message = "版本不能为空")
    @TableField(fill = FieldFill.INSERT)
    private Integer revision;

    /**
<<<<<<< HEAD
     *@description: 状态
     */
   /* @TableField(fill =FieldFill.INSERT)
    @NotEmpty(message = "状态不能为空")
    private Integer status;*/

    /**
=======
>>>>>>> 182355ee1ffc96de8a8cd1bfa30f0dd7a69d4dfb
     *@description: 创建人ID
     */
    @NotEmpty(message = "创建者不能为空")
    @TableField(fill = FieldFill.INSERT)
    private Long createdBy;

    /**
     *@description: 创建时间
     */

    @TableField(fill = FieldFill.INSERT)
    @NotEmpty(message = "创建时间不能为空")
    private LocalDateTime createdTime;

    /**
     *@description: 修改人ID
     */

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updatedBy;

    /**
     *@description: 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedTime;

    /**
     *@description: 逻辑删除
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
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
                revision.equals(that.revision) &&
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
        result = prime * result + ((revision == null) ? 0 : revision.hashCode());

      //  result = prime * result + ((status == null) ? 0 : status.hashCode());

        result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
        result = prime * result + ((createdTime == null) ? 0 : createdTime.hashCode());
        result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
        result = prime * result + ((updatedTime == null) ? 0 : updatedTime.hashCode());
        result = prime * result + ((deleted == null) ? 0 : deleted.hashCode());
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

   /* public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }*/

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", revision=" + revision +
               // ", status=" + status +
                ", createdBy=" + createdBy +
                ", createdTime=" + createdTime +
                ", updatedBy=" + updatedBy +
                ", updatedTime=" + updatedTime +
                ", deleted=" + deleted +
                '}';
    }
}
