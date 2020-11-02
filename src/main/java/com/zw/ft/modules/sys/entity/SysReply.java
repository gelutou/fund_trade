package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * <p>
 *  系统需求回复表 
 * </p>
 *
 * @author Oliver
 * @since 2020-11-02
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_reply")
@Data
public class SysReply extends BaseEntity {


    private static final long serialVersionUID = 1694450617113671449L;
    /**
     * 系统需求ID
     */
    @NotEmpty(message = "系统需求ID（needId）不能为空")
    private Integer needId;

    /**
     * 回复父级ID
     */
    private Integer parentId;

    /**
     * 回复内容
     */
    private String content;

    /**
     *@description: 子回复集合
     */
    @TableField(exist = false)
    private List<SysReply> children;

}
