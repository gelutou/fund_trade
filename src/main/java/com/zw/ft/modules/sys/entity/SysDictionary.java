package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <p>
 * 系统字典表 
 * </p>
 *
 * @author Oliver
 * @since 2020-12-03
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_dictionary")
@Data
public class SysDictionary extends BaseEntity {

    private static final long serialVersionUID = -2015650818483397908L;
    /**
     * 名称
     */
    private String name;

    /**
     * 父id
     */
    private Long pId;

    /**
     * 描述
     */
    private String des;

    /**
     * 实际值
     */
    private String value;

    /**
     * 顺序排序
     */
    private Integer sort;

    /**
     * 选择次数，用于排序
     */
    private Integer time;

    /**
     * 子项
     */
    @TableField(exist = false)
    private List<SysDictionary> children;
}
