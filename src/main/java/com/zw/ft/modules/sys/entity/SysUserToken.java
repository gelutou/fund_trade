package com.zw.ft.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zw.ft.common.base.BaseEntity;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * <p>
 *  系统用户token表
 * </p>
 *
 * @author Oliver
 * @since 2020-09-25
 */
@Data
public class SysUserToken extends BaseEntity {

    private static final long serialVersionUID = 5631168085771768786L;
    /**
     * 用户
     */
    private Integer userId;

    /**
     * token
     */
    private String token;

    /**
     * token更新时间
     */
    private Date tokenUpdateTime;

    /**
     *@description: 用户实体
     */
    @TableField(exist = false)
    private SysUserEntity user;

}
