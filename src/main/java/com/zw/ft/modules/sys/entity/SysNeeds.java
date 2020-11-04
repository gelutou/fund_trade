package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zw.ft.common.base.BaseEntity;
import java.time.LocalDateTime;
import java.util.List;
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
    private long deptId;

    /**
     * 期望日期
     */
    private String expectedTime;

    /**
     * 处理人
     */
    private Integer handler;

    /**
     * 实际完成日期
     */
    private String actualCompletionTime;

    /**
     * 确认人
     */
    private Integer confirmer;

    /**
     * 确认日期
     */
    private String confirmTime;

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
    private List<SysReply> sysReply;
}
