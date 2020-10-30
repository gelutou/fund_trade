package com.zw.ft.modules.sys.entity;

import com.zw.ft.common.base.BaseEntity;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;

/**
 * <p>
 *  系统需求表
 * </p>
 *
 * @author Oliver
 * @since 2020-10-29
 */
public class SysNeeds extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 所属部门
     */
    private Integer deptId;

    /**
     * 期望日期
     */
    private Date expectedTime;

    /**
     * 处理人
     */
    private Integer handler;

    /**
     * 实际完成日期
     */
    private Date actualCompletionTime;

    /**
     * 确认人
     */
    private Integer confirmer;

    /**
     * 确认日期
     */
    private Date confirmTime;

    /**
     * 状态 0未解决1已解决2完成
     */
    private Integer status;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Date getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(Date expectedTime) {
        this.expectedTime = expectedTime;
    }

    public Integer getHandler() {
        return handler;
    }

    public void setHandler(Integer handler) {
        this.handler = handler;
    }

    public Date getActualCompletionTime() {
        return actualCompletionTime;
    }

    public void setActualCompletionTime(Date actualCompletionTime) {
        this.actualCompletionTime = actualCompletionTime;
    }

    public Integer getConfirmer() {
        return confirmer;
    }

    public void setConfirmer(Integer confirmer) {
        this.confirmer = confirmer;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysNeeds{" +
        "title=" + title +
        ", content=" + content +
        ", deptId=" + deptId +
        ", expectedTime=" + expectedTime +
        ", handler=" + handler +
        ", actualCompletionTime=" + actualCompletionTime +
        ", confirmer=" + confirmer +
        ", confirmTime=" + confirmTime +
        ", status=" + status +
        "}";
    }
}
