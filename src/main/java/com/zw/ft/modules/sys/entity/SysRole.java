package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @ClassName SysRole
 * @Description 系统角色实体
 * @Author Oliver
 * @Date 2020/9/10 9:36
 * @Version 1.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_role")
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 2102161014072264011L;
    /**
     * @description: 角色编号
     */
    private String code;
    /**
     * @description: 角色名称
     */
    private String name;

    /**
     * @description: 用户集合
     */
    private List<SysUser> users;
}
