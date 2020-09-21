package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zw.ft.common.base.BaseEntity;

/**
 * @ClassName SysPermission
 * @Description SysPermission
 * @Author Oliver
 * @Date 2020/9/14 18:04
 * @Version 1.0
 **/
@TableName(value = "sys_permission")
public class SysPermissionEntity extends BaseEntity {
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

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isBlank() {
        return isBlank;
    }

    public void setBlank(boolean blank) {
        isBlank = blank;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "menuName='" + menuName + '\'' +
                ", menuDescription='" + menuDescription + '\'' +
                ", url='" + url + '\'' +
                ", isBlank=" + isBlank +
                ", parentId=" + parentId +
                ", perms='" + perms + '\'' +
                ", type=" + type +
                ", icon='" + icon + '\'' +
                '}';
    }
}
