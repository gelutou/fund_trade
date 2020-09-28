package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *  系统用户token表
 * </p>
 *
 * @author Oliver
 * @since 2020-09-25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserToken extends BaseEntity {

    private static final long serialVersionUID = 5631168085771768786L;
    /**
     * 用户
     */
    private long userId;

    /**
     * token
     */
    private String token;

    /**
     *@description: 用户实体
     */
    @TableField(exist = false)
    private SysUser user;

}
