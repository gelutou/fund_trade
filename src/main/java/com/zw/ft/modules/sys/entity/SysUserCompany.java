package com.zw.ft.modules.sys.entity;

import com.zw.ft.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 员工公司信息表 
 * </p>
 *
 * @author Oliver
 * @since 2020-09-21
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserCompany extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Integer comId;

    private Integer userId;

}
