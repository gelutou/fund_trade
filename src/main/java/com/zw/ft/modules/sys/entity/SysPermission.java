package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName SysPermission
 * @Description SysPermission
 * @Author Oliver
 * @Date 2020/9/14 18:04
 * @Version 1.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_permission")
public class SysPermission extends BaseEntity {
    private static final long serialVersionUID = -1751105463923119269L;

    /**
     *@description: 菜单名字
     */
    private String menuName;
    /**
     *@description: 菜单描述
     */
    private String menuDescription;
    /**
     *@description: 资源路径
     */
    private String url;
    /**
     *@description: 是否跳转 0是 1否
     */
    private boolean isBlank;
    /**
     *@description: 父菜单ID
     */
    private long parentId;
    /**
     *@description: 权限
     */
    private String perms;
    /**
     *@description: 类型   0：目录   1：菜单   2：按钮
     */
    private Integer type;
    /**
     *@description: 图标
     */
    private String icon;
}
