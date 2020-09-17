package com.zw.ft.common.base;

import com.baomidou.mybatisplus.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Timestamp;

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
    private Integer revision;
    /**
     *@description: 状态（包括逻辑删除）
     */
    @TableLogic
    @NotEmpty(message = "状态不能为空")
    private Integer status;
    /**
     *@description: 创建人ID
     */
    @NotEmpty(message = "创建者不能为空")
    private Long createdUserId;
    /**
     *@description: 创建时间
     */
    @NotEmpty(message = "创建时间不能为空")
    private Timestamp createdTime;
    /**
     *@description: 修改人ID
     */
    private Long updatedUserId;
    /**
     *@description: 修改时间
     */
    private Timestamp updatedTime;

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
                status.equals(that.status) &&
                createdUserId.equals(that.createdUserId) &&
                createdTime.equals(that.createdTime) &&
                updatedUserId.equals(that.updatedUserId) &&
                updatedTime.equals(that.updatedTime);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((revision == null) ? 0 : revision.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((createdUserId == null) ? 0 : createdUserId.hashCode());
        result = prime * result + ((createdTime == null) ? 0 : createdTime.hashCode());
        result = prime * result + ((updatedUserId == null) ? 0 : updatedUserId.hashCode());
        result = prime * result + ((updatedTime == null) ? 0 : updatedTime.hashCode());
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(Long updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", revision=" + revision +
                ", status=" + status +
                ", createdUserId=" + createdUserId +
                ", createdTime=" + createdTime +
                ", updatedUserId=" + updatedUserId +
                ", updatedTime=" + updatedTime +
                '}';
    }
}
