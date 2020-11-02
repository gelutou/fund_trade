package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zw.ft.common.base.BaseEntity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *  系统需求表
 * </p>
 *
 * @author Oliver
 * @since 2020-10-29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysNeeds extends BaseEntity {

    private static final long serialVersionUID = -6708994052557758569L;
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
    private LocalDateTime expectedTime;

    /**
     * 处理人
     */
    private Integer handler;

    /**
     * 实际完成日期
     */
    private LocalDateTime actualCompletionTime;

    /**
     * 确认人
     */
    private Integer confirmer;

    /**
     * 确认日期
     */
    private LocalDateTime confirmTime;

    /**
     * 状态 0未解决1已解决2已确认
     */
    private Integer status;

    /**
     * 状态(中文) 0未解决1已解决2已确认
     */
    @TableField(exist = false)
    private String statusDes;

    /**
     * 提出人
     */
    @TableField(exist = false)
    private SysUser proposer;

    /**
     * 所属部门信息
     */
    @TableField(exist = false)
    private SysDepartment dept;

    /**
     * 处理人
     */
    @TableField(exist = false)
    private SysUser handleUser;

    /**
     * 确认人
     */
    @TableField(exist = false)
    private SysUser confirmerUser;

    /**
     * 回复
     */
    @TableField(exist = false)
    private SysReply sysReply;
}
